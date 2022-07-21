package co.com.sofkau.usecase.cardusecase.getcardsusecase;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetCardsUseCase {
    private final CardRepository cardRepository;

    public Flux<Card> obtenerCartas() {
        return cardRepository.findAll();
    }

}
