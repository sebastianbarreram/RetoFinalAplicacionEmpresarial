package co.com.sofkau.usecase.playerusecase.updateplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePlayerUseCase {

    private final PlayerRepository repository;

    public Mono<Player> updatePlayer(String id, Player player) {
        return repository.updatePlayer(id, player);
    }

}
