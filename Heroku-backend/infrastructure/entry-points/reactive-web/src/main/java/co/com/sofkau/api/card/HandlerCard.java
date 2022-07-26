package co.com.sofkau.api.card;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.cardusecase.createcardusecase.CreateCardUseCase;
import co.com.sofkau.usecase.cardusecase.deletecard.DeleteCardUseCase;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import co.com.sofkau.usecase.cardusecase.getrandomcards.GetRandomCardsUseCase;
import co.com.sofkau.usecase.cardusecase.listbyid.ListByIdUseCase;
import co.com.sofkau.usecase.cardusecase.updatecard.UpdateCardUseCase;
import co.com.sofkau.usecase.cardusecase.listbyplayerid.ListByPlayerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerCard {
    private final CreateCardUseCase createCardUseCase;
    private final DeleteCardUseCase deleteCardUseCase;
    private final GetCardsUseCase getCardsUseCase;
    private final ListByIdUseCase listByIdUseCase;
    private final UpdateCardUseCase updateCardUseCase;

    private final GetRandomCardsUseCase getRandomCardsUseCase;

    private final ListByPlayerIdUseCase listByPlayerIdUseCase;

    public Mono<ServerResponse> listenPOSTCreateCardUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Card.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createCardUseCase.crearCarta(element), Card.class));
    }

    public Mono<ServerResponse> listenDELETECardUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("cardId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCardUseCase.eliminarCarta(id), Card.class);
    }

    public Mono<ServerResponse> listenGETCardsUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCardsUseCase.obtenerCartas(), Card.class);
    }

    public Mono<ServerResponse> listenGETListByIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("cardId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listByIdUseCase.listarIdCard(id), Card.class);
    }

    public Mono<ServerResponse> listenPUTUpdateCardUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("cardId");
        return serverRequest.bodyToMono(Card.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateCardUseCase.actualizarCarta(id, element), Card.class));
    }

    public Mono<ServerResponse> listenGETRandomCards(ServerRequest serverRequest) {
        var numberOfCards = Integer.valueOf(serverRequest.pathVariable("numberOfCards"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getRandomCardsUseCase.obtenerCartasAleatorias(numberOfCards), Card.class);
    }

    public Mono<ServerResponse> listenGETListByPlayerId(ServerRequest serverRequest){
        var playerID=serverRequest.pathVariable("playerId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listByPlayerIdUseCase.listarCardByPlayerId(playerID),Card.class);
    }
}
