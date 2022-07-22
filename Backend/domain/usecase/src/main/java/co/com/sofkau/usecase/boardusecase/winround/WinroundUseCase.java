package co.com.sofkau.usecase.boardusecase.winround;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import co.com.sofkau.usecase.gameusecase.getgame.GetgameUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class WinroundUseCase {
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

   /* Mono<Board> DefineWinRound(){
           var cardMono = cardRepository.findById()
                        .map(e->e.getXp())
                        .reduce((exp1,exp2)->(exp1>exp2)? exp1:exp2)

    }*/
}
