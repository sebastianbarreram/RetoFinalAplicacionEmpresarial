package co.com.sofkau.api.player;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestPlayer {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionPlayer(HandlerPlayer handlerPlayer) {
    return route(POST("/player"), handlerPlayer::listenPostAddPlayerUseCase)
            .and(route(GET("/player"), handlerPlayer::listenListAllPlayersUseCase))
            .and(route(GET("/player/{id}"), handlerPlayer::listenListPlayerByIdUseCase))
            .and(route(PUT("/player/{id}"), handlerPlayer::listenUpdatePlayerUseCase))
            .and(route(DELETE("/player/{id}"), handlerPlayer::listenDeletePlayerUseCase));
    }
}