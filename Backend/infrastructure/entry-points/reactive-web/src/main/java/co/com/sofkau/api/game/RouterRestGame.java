package co.com.sofkau.api.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestGame {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionGame(HandlerGame handlerGame) {
        return route(POST("/api/usecase/game"), handlerGame::createGamePostUseCase)
                .and(route(GET("/api/game"), handlerGame::listGameGETUseCase))
                .and(route(DELETE("/api/game/{id}"), handlerGame::listDELETEGameUseCase));
               // .and(route(PUT("/game/{id}"), handlerGame::listenUpdatePlayerUseCase));

    }
}
