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
    return route(POST("/api/player"), handlerPlayer::listenPostAddPlayerUseCase)
            .and(route(GET("/api/player"), handlerPlayer::listenListAllPlayersUseCase))
            .and(route(GET("/api/player/{id}"), handlerPlayer::listenListPlayerByIdUseCase))
            .and(route(PUT("/api/player/{id}"), handlerPlayer::listenUpdatePlayerUseCase))
            .and(route(PUT("/api/player/points/{points}"), handlerPlayer::listenaddPointsHistoryUseCase))
            .and(route(PUT("/api/player/score/{score}"), handlerPlayer::listenaddScoreUseCase))
            .and(route(DELETE("/api/player/{id}"), handlerPlayer::listenDeletePlayerUseCase));
    }
}