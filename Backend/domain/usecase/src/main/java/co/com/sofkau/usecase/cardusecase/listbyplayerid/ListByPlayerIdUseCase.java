package co.com.sofkau.usecase.cardusecase.listbyplayerid;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListByPlayerIdUseCase {
    private final CardRepository cardRepository;
    public Flux<Card> listarCardByPlayerId(String playerId) {
        Flux<Card> playerCards = cardRepository
                .findAll()
                .filter(filtro -> filtro.getPlayerId().equals(playerId)) ;
        return cardRepository.findByPlayerId(playerCards);
    }
}
