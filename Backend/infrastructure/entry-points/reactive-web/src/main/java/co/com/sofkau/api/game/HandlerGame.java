package co.com.sofkau.api.game;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.gamecard.gateways.GameRepository;
import co.com.sofkau.usecase.gameusecase.creategame.CreateGameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerGame {
    private final CreateGameUseCase createGameUseCase;
    private final GameRepository gameRepository;

    public Mono<ServerResponse> createGamePostUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Game.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createGameUseCase.createGame(element), Game.class));
    }

    public Mono<ServerResponse> listGameGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gameRepository.findAll(), Game.class);
    }

}
