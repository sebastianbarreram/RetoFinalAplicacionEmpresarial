package co.com.sofkau.usecase.boardusecase.reallocatecards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.boardusecase.winround.WinroundUseCase;
import co.com.sofkau.usecase.cardusecase.updatecard.UpdateCardUseCase;
import co.com.sofkau.usecase.playerusecase.findplayer.FindPlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ReallocateCardsUseCase {
    private final BoardRepository boardRepository;

    private final GettablerobyidUseCase gettablerobyidUseCase;
    private final WinroundUseCase winroundUseCase;
    private  final FindPlayerUseCase findPlayerUseCase;

    public Mono<Board> ReallocateCardsUseCase(String idBoard){

        //var listCardRound = gettablerobyidUseCase.listBoardId(idBoard).map(board -> board.getListCard());

        //var winId = winroundUseCase.winRound(idBoard).toFuture().join();
        //var playerWin = findPlayerUseCase.findPlayer(winId).toFuture().join();

        //var listCardPlayer =   listCardRound.zipWith( Mono.just(playerWin.getCardModels()));


        //var listCardPlayer =   Mono.


        //playerWin.setCardModels(listCardPlayer);




        //return boardRepository.update(id,board);

        return null;
    }

}
