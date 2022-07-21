package co.com.sofkau.usecase.playerusecase.findplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindPlayerUseCase {

    private final PlayerRepository repository;

    public Mono<Player> findPlayer(String id) {
        return repository.findById(id);
    }
}
