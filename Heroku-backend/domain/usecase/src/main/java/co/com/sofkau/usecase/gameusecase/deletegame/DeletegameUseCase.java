package co.com.sofkau.usecase.gameusecase.deletegame;

import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletegameUseCase {
    private final GameRepository repository;

    public Mono<Void>deleteGame(String id){
        return repository.delete(id);
    }
}
