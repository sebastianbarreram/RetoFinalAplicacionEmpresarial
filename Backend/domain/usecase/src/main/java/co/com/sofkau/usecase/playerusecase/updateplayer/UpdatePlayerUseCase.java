package co.com.sofkau.usecase.playerusecase.updateplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlayerUseCase {

    private  PlayerRepository repository;

    public Mono<Player> updatePlayer(Player player, String id) {
        return repository.update(id, player);
    }

}
