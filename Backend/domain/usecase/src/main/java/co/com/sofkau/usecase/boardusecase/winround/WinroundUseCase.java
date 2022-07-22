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
import java.util.Optional;

@RequiredArgsConstructor
public class WinroundUseCase {
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    Mono<Optional<Card>> DefineWinRound(String id){
        var cardMono = boardRepository.findById(id)
                        .map(e->e.getListCard().stream()
                                .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2))
                   ;
        return cardMono;
    }
}
