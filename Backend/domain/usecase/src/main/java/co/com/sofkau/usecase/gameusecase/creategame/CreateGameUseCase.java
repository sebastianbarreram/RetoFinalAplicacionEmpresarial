package co.com.sofkau.usecase.gameusecase.creategame;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateGameUseCase {

    private final GameRepository repository;

    public Mono<Game> createGame(Game game){
        return repository.save(game);
    }

}
