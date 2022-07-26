package co.com.sofkau.usecase.cardusecase.createcardusecase;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCardUseCase {
    private final CardRepository cardRepository;

    public Mono<Card> crearCarta(Card card) {
        return cardRepository.save(card);
    }
}
