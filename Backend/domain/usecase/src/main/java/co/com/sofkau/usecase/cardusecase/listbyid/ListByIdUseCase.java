package co.com.sofkau.usecase.cardusecase.listbyid;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListByIdUseCase {
    private final CardRepository cardRepository;

    public Mono<Card> listarIdCard(String id) {
        return cardRepository.findById(id);
    }
}
