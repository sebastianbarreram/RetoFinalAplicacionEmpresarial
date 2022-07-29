package co.com.sofkau.usecase.boardusecase.reallocatecards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.boardusecase.addcardsinboard.AddCardsInBoardUseCase;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.gameusecase.getgame.GetgameUseCase;
import co.com.sofkau.usecase.gameusecase.listgamebyid.ListgamebyidUseCase;
import co.com.sofkau.usecase.gameusecase.winround.WinroundUseCase;
import co.com.sofkau.usecase.playerusecase.findplayer.FindPlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ReallocateCardsUseCase {

    private final BoardRepository boardRepository;
    private final GettablerobyidUseCase gettablerobyidUseCase;
    private final WinroundUseCase winroundUseCase;
    private final FindPlayerUseCase findPlayerUseCase;
    private final ListgamebyidUseCase listgamebyidUseCase;

    private final AddCardsInBoardUseCase addCardsInBoardUseCase;

    public Mono<Board> reallocateCards(String idBoard) {

        Card cardNull = new Card("0", 0, "",true,"0");

        var game = listgamebyidUseCase.listGameId("1").toFuture().join();
        var listCardRound = game.getCardGamesList();
        var winId = winroundUseCase.winRound(game.getId()).toFuture().join().getPlayerId();


        var listCardRoundNew =
                listCardRound.stream()
                        .map(
                                card -> {
                                    return new Card(
                                            card.getCardId(), card.getXp(), card.getImage(), card.getHidden(), winId);
                                    // addCardsInBoardUseCase.addCardsInGame(newCard.getPlayerId());
                                })
                        .collect(Collectors.toList());

        var newBoard =
                gettablerobyidUseCase
                        .listBoardId("62de01f1ee60c664c3d720fb")
                        .map(
                                board -> {
                                    var newList =
                                            board.getListCard().stream()
                                                    .map(
                                                            card -> {
                                                                var list = new ArrayList<Card>();
                                                                listCardRoundNew.stream()
                                                                        .forEach(
                                                                                newCards -> {
                                                                                    if (!newCards.getCardId().equals(card.getCardId())) {
                                                                                        list.add(card);
                                                                                    }
                                                                                });

                                                                var newList2 = new ArrayList<Card>();


                                                                if (list.size() == game.getCardGamesList().size()) {
                                                                    newList2.add(list.get(0));

                                                                }else{
                                                                    newList2.add(cardNull);
                                                                }


                                                                return newList2.get(0);
                                                            }).filter(card -> !card.getCardId().equals("0")).collect(Collectors.toList());

                                    newList.addAll(listCardRoundNew);

                                    return new Board(
                                            board.getId(),
                                            board.getTime(),
                                            board.getListWinRound(),
                                            newList,
                                            board.getListplayer(),
                                            board.getIdPlayers());
                                })
                        .toFuture()
                        .join();

        return boardRepository.update("62de01f1ee60c664c3d720fb", newBoard);
    }
}
