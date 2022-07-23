package co.com.sofkau.usecase.boardusecase.tiebreak;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.boardusecase.winround.WinroundUseCase;
import co.com.sofkau.usecase.gameusecase.getgame.GetgameUseCase;
import co.com.sofkau.usecase.gameusecase.listgamebyid.ListgamebyidUseCase;
import co.com.sofkau.usecase.playerusecase.findplayer.FindPlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class TieBreakUseCase {
    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;
    private final GettablerobyidUseCase gettablerobyidUseCase;
    private final WinroundUseCase winroundUseCase;
    private final FindPlayerUseCase findPlayerUseCase;

    private final ListgamebyidUseCase listgamebyidUseCase;

    public Mono<Board> tieBreak(String id) {
       /* var listPlayer = gettablerobyidUseCase.listBoardId(idBoard).map(board -> board.getId());

        var winId = winroundUseCase.winRound(idBoard).toFuture().join();
        var playerWin = findPlayerUseCase.findPlayer(winId).toFuture().join();



        var listCardRoundNew= listCardRound.map(lists -> {
            return lists.stream().map(
                    card -> {
                        return new Card(
                                card.getCardId(),
                                card.getXp(),
                                card.getImage(),
                                card.getHidden(),
                                winId);
                    }).collect(Collectors.toList());
        }).toFuture().join();

        var listsCardPlayerNew=  Mono.just(playerWin.getCardModels()).toFuture().join();
        List<Card> listCardPlayer = Stream.concat(listCardRoundNew.stream(), listsCardPlayerNew.stream()).collect(Collectors.toList());

        playerWin.setCardModels(listCardPlayer);

        return  playerRepository.reallocateCards(playerWin);
*/
        return boardRepository.findById(id);
    }

}
