package co.com.sofkau.usecase.gameusecase.retiregameplayer;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RetireGamePlayerUseCase {
    private final GameRepository repository;
    public Mono<Game> retireGamePlayer(String idPlayer, Game game){
        List<Player> playerNew =  game.getPlayerModelList().stream().filter(player-> !player.getPlayerId().equals(idPlayer) ).collect(Collectors.toList());

        game.setPlayerModelList(playerNew);

        return repository.retireGamePlayer(game);
    }
}
