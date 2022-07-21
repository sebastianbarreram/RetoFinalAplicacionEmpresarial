package co.com.sofkau.usecase.playerusecase.addplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddPlayerUseCase {
    private final PlayerRepository repository;

    public Mono<Player> addPlayer(Player player) {
        return repository.save(player);
    }
}
