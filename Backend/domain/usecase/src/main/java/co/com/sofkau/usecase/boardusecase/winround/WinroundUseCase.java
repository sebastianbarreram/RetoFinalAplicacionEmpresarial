package co.com.sofkau.usecase.boardusecase.winround;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class WinroundUseCase {
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    public Mono<String> winRound(String id){
        var cardMono = boardRepository.findById(id)
                        .map(e->e.getListCard().stream()
                               .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2));
        return  boardRepository.winRound(cardMono);
    }
}
