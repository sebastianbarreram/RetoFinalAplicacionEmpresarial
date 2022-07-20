package co.com.sofkau.usecase.gameusecase.dealcards;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class DealCardsUseCase {
    private final GameRepository repository;
    public Flux<Game> listCards(){
        return repository.findAll();
    }
}
