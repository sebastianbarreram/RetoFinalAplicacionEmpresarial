package co.com.sofkau.api;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
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
                .flatMap(element -> createGameUseCase.createGame(element)) //es un flujo alterno-proceso de almacenamiento retorna otro flujo ya que el metodo del usecase guarda
                .flatMap(element -> ServerResponse.ok() //es el flujo que combierte la respuesta anterior a un body
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(gameRepository.save(element), Game.class));
    }
    public Mono<ServerResponse> listGameGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gameRepository.findAll(), Game.class);
    }

}
