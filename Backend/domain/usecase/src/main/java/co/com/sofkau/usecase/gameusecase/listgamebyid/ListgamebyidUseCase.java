package co.com.sofkau.usecase.gameusecase.listgamebyid;


import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListgamebyidUseCase {
    private final GameRepository gameRepository;

    public Mono<Game> listGameId(String id) {
        return gameRepository.findById(id);
    }
}
