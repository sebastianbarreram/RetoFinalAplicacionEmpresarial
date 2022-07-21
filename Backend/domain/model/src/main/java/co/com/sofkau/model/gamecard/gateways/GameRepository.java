package co.com.sofkau.model.gamecard.gateways;

import co.com.sofkau.model.game.Game;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GameRepository {
    Mono<Game> save(Game game);

    Flux<Game> findAll();

    Mono<Game> findById(String id);

    Mono<Void> delete(String id);

    Mono<Game> update(String id, Game game);
}
