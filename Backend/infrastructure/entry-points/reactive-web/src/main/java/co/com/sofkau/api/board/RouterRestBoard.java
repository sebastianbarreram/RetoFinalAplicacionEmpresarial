package co.com.sofkau.api.board;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRestBoard {
@Bean
public RouterFunction<ServerResponse> routerFunctionBoard(HandlerBoard handler) {
    return route(POST("/api/board"), handler::listenPOSTCreateBoardUseCase)
            .andRoute(PUT("/api/board/{id}"), handler::listenPUTUpdateBoardUseCase)
            .and(route(PUT("/api/board/reallocatecards/{id}"), handler::listenReallocateCardsUseCase))
            .and(route(PUT("/api/board/tiebreak/{id}"), handler::listenTieBreakUseCase))
            .andRoute(GET("/api/board/{id}"), handler::listenGETListByIdUseCase)
            .andRoute(PUT("/api/board/set/{id}"),handler::listenUseCardUseCase)
            .andRoute(PUT("/api/board/player/{idplayer}"),handler::listenAddPlayerInBoardUseCase)
            .andRoute(PUT("/api/board/playerid/{idplayer}"),handler::listenAddPlayerIdInBoardUseCase)
            .andRoute(PUT("/api/board/players/{idboard}"),handler::listenUpdatePlayerInBoardUseCase);
    }
}
