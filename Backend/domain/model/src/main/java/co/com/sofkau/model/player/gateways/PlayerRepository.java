package co.com.sofkau.model.player.gateways;

import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository {

    Mono<Player> save(Player player);
    Flux<Player> findAll();
    Mono<Player> findById(String id);
    Mono<Void> delete(String id);
    Mono<Player> updatePlayer(String id, Player player);
    Mono<Player> addPointsHistory(Player player);
    Mono<Player> addScore(Player player);

    Mono<Player> reallocateCards(Player player);
}
