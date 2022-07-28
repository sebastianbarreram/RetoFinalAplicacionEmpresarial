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

        var game = listgamebyidUseCase.listGameId("1").toFuture().join();
        var listCardRound = game.getCardGamesList();
        var winId = winroundUseCase.winRound(game.getId()).toFuture().join().getPlayerId();

        var listCardRoundNew = listCardRound.stream().map(
                card -> {
                    return new Card(
                            card.getCardId(),
                            card.getXp(),
                            card.getImage(),
                            card.getHidden(),
                            winId);
                    //addCardsInBoardUseCase.addCardsInGame(newCard.getPlayerId());
                }).collect(Collectors.toList());

        var boardStream = listCardRoundNew.stream().map(
                newCard -> {
                    var newBoard = gettablerobyidUseCase.listBoardId("62de01f1ee60c664c3d720fb").map(
                            board -> {
                                var listCards2 = board.getListCard().stream().map(
                                        Card -> {
                                            if (newCard.getCardId().equals(Card.getCardId())) {
                                                return newCard;
                                            }
                                            return Card;
                                        }
                                ).collect(Collectors.toList());

                                return new Board(
                                        board.getId(),
                                        board.getTime(),
                                        board.getListWinRound(),
                                        listCards2,
                                        board.getListplayer(),
                                        board.getIdPlayers()
                                );
                            }).toFuture().join();
                    return  newBoard;
                }
        ).collect(Collectors.toList()).get(0);


        return boardRepository.update("62de01f1ee60c664c3d720fb"
                , boardStream);

    }
}
