package co.com.sofkau.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration

public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerGame handlerGame) {
    return route(POST("/api/usecase/game"), handlerGame::createGamePostUseCase)
            .and(route(GET("/api/game"), handlerGame::listGameGETUseCase));
    }
}
