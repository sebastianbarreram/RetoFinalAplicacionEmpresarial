package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.cardusecase.createcardusecase.CreateCardUseCase;
import co.com.sofkau.usecase.cardusecase.deletecard.DeleteCardUseCase;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import co.com.sofkau.usecase.cardusecase.getrandomcards.GetRandomCardsUseCase;
import co.com.sofkau.usecase.cardusecase.listbyid.ListByIdUseCase;
import co.com.sofkau.usecase.cardusecase.listbyplayerid.ListByPlayerIdUseCase;
import co.com.sofkau.usecase.cardusecase.updatecard.UpdateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerBoard {
    private final CreateCardUseCase createCardUseCase;
    private final DeleteCardUseCase deleteCardUseCase;
    private final GetCardsUseCase getCardsUseCase;
    private final ListByIdUseCase listByIdUseCase;
    private final UpdateCardUseCase updateCardUseCase;
    private final GettablerobyidUseCase gettablerobyidUseCase;
    private final GetRandomCardsUseCase getRandomCardsUseCase;
    private final ListByPlayerIdUseCase listByPlayerIdUseCase;

    public Mono<ServerResponse> listenGETListByIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gettablerobyidUseCase.listBoardId(id), Board.class);
    }
}
