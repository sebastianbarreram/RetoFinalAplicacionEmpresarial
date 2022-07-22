package co.com.sofkau.api.game;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.gameusecase.creategame.CreateGameUseCase;
import co.com.sofkau.usecase.gameusecase.dealcards.DealCardsUseCase;
import co.com.sofkau.usecase.gameusecase.deletegame.DeletegameUseCase;
import co.com.sofkau.usecase.gameusecase.getgame.GetgameUseCase;
import co.com.sofkau.usecase.gameusecase.listgamebyid.ListgamebyidUseCase;
import co.com.sofkau.usecase.gameusecase.updategame.UpdategameUseCase;
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
    private final DeletegameUseCase deletegameUseCase;
    private final UpdategameUseCase updategameUseCase;
    private final DealCardsUseCase dealCardsUseCase;
    private final GetgameUseCase getgameUseCase;
    private final ListgamebyidUseCase listgamebyidUseCase;

    public Mono<ServerResponse> createGamePostUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Game.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createGameUseCase.createGame(element), Game.class));
    }
    public Mono<ServerResponse> listenGameGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getgameUseCase.listGames(), Game.class);
    }
    public Mono<ServerResponse> listenDELETEGameUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletegameUseCase.deleteGame(id), Game.class);
    }
    public Mono<ServerResponse> listenPUTUpdateGameUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Game.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updategameUseCase.updateGame(id,element), Game.class));
    }
    public Mono<ServerResponse> listenGETListByIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listgamebyidUseCase.listGameId(id), Game.class);
    }

}
