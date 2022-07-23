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
    return route(GET("/api/board/win/{id}"), handler::listenGetWinBoardUseCase)
            .andRoute(POST("/api/usecase/board"), handler::listenPOSTCreateBoardUseCase)
            .andRoute(PUT("/api/board"), handler::listenPUTUpdateBoardUseCase)
            .andRoute(GET("/api/board/{id}"), handler::listenGETListByIdUseCase)
            ;
    }
}
