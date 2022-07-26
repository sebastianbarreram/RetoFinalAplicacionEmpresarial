package co.com.sofkau.usecase.boardusecase.wingame;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class WinGameUseCase {
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;


    public Mono<String> winGame(String id){

        var playerId = boardRepository.findById(id)
                .map( board ->  board.getListplayer().stream()
                        .reduce((value1,value2)->{
                            return (value1.getCardModels().size() >value2.getCardModels().size())
                                    ?value1
                                    :value2
                                    ;
                        }))
                .map( player -> {
                    return (player.isPresent())
                            ? player.get().getPlayerId() : "Ningun jugador";
                    }
                    );
        return  boardRepository.winGame(playerId);
    }
}
