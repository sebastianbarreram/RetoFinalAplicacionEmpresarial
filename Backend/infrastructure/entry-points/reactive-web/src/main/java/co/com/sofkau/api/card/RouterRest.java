package co.com.sofkau.api.card;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(HandlerCard handler) {
    return route(POST("/api/cards"), handler::listenPOSTCreateCardUseCase)
    .andRoute(DELETE("/api/cards/{cardId}"), handler::listenDELETECardUseCase)
    .andRoute(GET("/api/cards"), handler::listenGETCardsUseCase)
    .andRoute(GET("/api/cards/{cardId}"), handler::listenGETListByIdUseCase)
            .and(route(PUT("/api/cards/{cardId}"), handler::listenPUTUpdateCardUseCase))
            .andRoute(GET("/api/cards/random/{numberOfCards}"),handler::listenGETRandomCards)
            .andRoute(GET("/api/cards/player/{playerId}"),handler::listenGETListByPlayerId);
    }
}
