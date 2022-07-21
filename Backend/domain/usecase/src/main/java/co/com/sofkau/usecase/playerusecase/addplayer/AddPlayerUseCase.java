package co.com.sofkau.usecase.playerusecase.addplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

public class AddPlayerUseCase {

    public AddPlayerUseCase() {

    }

    public AddPlayerUseCase(PlayerRepository repository) {
        this.repository = repository;
    }

    private PlayerRepository repository;

    public Mono<Player> addPlayer(Player transformerPlayer) {
        return repository.save(transformerPlayer);
    }
}
