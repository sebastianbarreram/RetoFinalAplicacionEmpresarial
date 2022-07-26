package co.com.sofkau.usecase.playerusecase.listsplayers;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListsPlayersUseCase {
    private final PlayerRepository repository;

    public Flux<Player> listsPlayers() {
        return repository.findAll();
    }
}
