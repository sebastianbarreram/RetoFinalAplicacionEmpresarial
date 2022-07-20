package co.com.sofkau.model.gamecard.gateways;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.gamecard.GameCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GameCardRepository {
    Mono<GameCard> save(GameCard gameCard);

    Flux<GameCard> findAll();

    Mono<GameCard> findById(String id);

    Mono<Void> delete(String id);

    Mono<GameCard> update(String id, GameCard gameCard);
}
