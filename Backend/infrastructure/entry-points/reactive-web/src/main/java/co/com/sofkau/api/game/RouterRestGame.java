package co.com.sofkau.api.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestGame {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionGame(HandlerGame handlerGame) {
        return route(POST("/api/usecase/game"), handlerGame::createGamePostUseCase)
                .and(route(GET("/api/game"), handlerGame::listGameGETUseCase));
    }
}
