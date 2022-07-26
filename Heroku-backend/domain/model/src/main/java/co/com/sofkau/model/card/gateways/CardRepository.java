package co.com.sofkau.model.card.gateways;

import co.com.sofkau.model.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CardRepository {
    Mono<Card> save(Card card);
    Flux<Card> findAll();
    Mono<Card> findById(String id);
    Mono<Void> delete(String id);
    Mono<Card> update(String id, Card card);
    Flux<Card> randomCards(List<Card> newCards);
    Flux<Card> findByPlayerId(Flux<Card> playerCards);
}
