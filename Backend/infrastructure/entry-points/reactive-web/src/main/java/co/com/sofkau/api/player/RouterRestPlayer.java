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
    public RouterFunction<ServerResponse> routerFunctionPlayer(HandlerPlayer handler) {
    return route(POST("/player/create"), handler::listenPOSTUseCase)
            .andRoute(GET("/player"), handler::listenGETUseCase);
    }
}
