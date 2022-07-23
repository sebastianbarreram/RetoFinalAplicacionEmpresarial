package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.boardusecase.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.playerusecase.reallocatecards.ReallocateCardsUseCase;
import co.com.sofkau.usecase.boardusecase.updateboard.UpdateboardUseCase;
import co.com.sofkau.usecase.boardusecase.usecard.UsecardUseCase;
import co.com.sofkau.usecase.boardusecase.winround.WinroundUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerBoard {
    private final UpdateboardUseCase updateboardUseCase;
    private final GettablerobyidUseCase gettablerobyidUseCase;
    private final CreateBoardUseCase createBoardUseCase;
    private final WinroundUseCase winroundUseCase;
    private final UsecardUseCase usecardUseCase;

    private final ReallocateCardsUseCase reallocateCardsUseCase;

    public Mono<ServerResponse> listenPOSTCreateBoardUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Board.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createBoardUseCase.createBoard(element), Board.class));
    }
    public Mono<ServerResponse> listenGETListByIdUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(gettablerobyidUseCase.listBoardId(id), Board.class);
    }
    public Mono<ServerResponse> listenPUTUpdateBoardUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Board.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateboardUseCase.updateBoard(id,element), Board.class));
    }
    public Mono<ServerResponse>listenGetWinBoardUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(winroundUseCase.winRound(id ), Board.class);
    }
    public Mono<ServerResponse>listenUseCardUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        var idCard = serverRequest.pathVariable("idCard");
        return  serverRequest.bodyToMono(Board.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(usecardUseCase.useCard(id,idCard,element),Board.class));
    }
}
