package co.com.sofkau.usecase.cardusecase.updatecard;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCardUseCase {
    private final CardRepository cardRepository;

    public Mono<Card> actualizarCarta(String id, Card card) {
        return cardRepository.update(id, card);
    }
}
