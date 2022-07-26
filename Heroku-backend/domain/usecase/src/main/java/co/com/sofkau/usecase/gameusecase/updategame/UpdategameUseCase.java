package co.com.sofkau.usecase.gameusecase.updategame;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdategameUseCase {
    private final GameRepository repository;
    public Mono<Game> updateGame(String id, Game game){
        return repository.updateGame(id,game);
    }
}
