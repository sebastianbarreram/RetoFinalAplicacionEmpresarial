package co.com.sofkau.usecase.cardusecase.getrandomcards;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetRandomCardsUseCase {
    private final CardRepository cardRepository;

    public Flux<Card> obtenerCartasAleatorias(Integer numeroDeCartas) {
        List<Card> cards = cardRepository.findAll().collectList().block();
        Collections.shuffle(cards);
        List<Card> newCards = cards.stream()
                .skip(cards.size() - numeroDeCartas)
                .collect(Collectors.toList());
        System.out.println(newCards);
//        return Flux.fromIterable(newCards);
        return cardRepository.randomCards(newCards);
    }

}
