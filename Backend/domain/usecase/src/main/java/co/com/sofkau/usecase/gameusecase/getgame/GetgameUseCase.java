package co.com.sofkau.usecase.gameusecase.getgame;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetgameUseCase {
    private final GameRepository gameRepository;

    public Flux<Game> listGames() {
        return gameRepository.findAll();
    }
}
