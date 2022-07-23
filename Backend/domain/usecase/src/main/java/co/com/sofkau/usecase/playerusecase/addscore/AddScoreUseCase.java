package co.com.sofkau.usecase.playerusecase.addscore;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddScoreUseCase {
    private final PlayerRepository repository;

    public Mono<Player> addScore(String score, Player player){

        Integer points = Integer.parseInt(score);

        player.setScore(points);

        return repository.addScore(player);
    }

}
