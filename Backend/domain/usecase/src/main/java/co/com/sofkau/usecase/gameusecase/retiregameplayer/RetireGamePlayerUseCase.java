package co.com.sofkau.usecase.gameusecase.retiregameplayer;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RetireGamePlayerUseCase {

    private final GameRepository repository;
    public Mono<Game> retireGamePlayer(String idPlayer, Game game){
        return repository.retireGamePlayer(idPlayer, game);
    }
}
