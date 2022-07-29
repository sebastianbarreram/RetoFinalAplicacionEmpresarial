package co.com.sofkau.api.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.boardusecase.addplayeridinboard.AddPlayerIdInBoardUseCase;
import co.com.sofkau.usecase.boardusecase.addplayerinboard.AddPlayerInBoardUseCase;
import co.com.sofkau.usecase.boardusecase.createboard.CreateBoardUseCase;
import co.com.sofkau.usecase.boardusecase.gettablerobyid.GettablerobyidUseCase;
import co.com.sofkau.usecase.boardusecase.tiebreak.TieBreakUseCase;
import co.com.sofkau.usecase.boardusecase.reallocatecards.ReallocateCardsUseCase;
import co.com.sofkau.usecase.boardusecase.updateboard.UpdateboardUseCase;
import co.com.sofkau.usecase.boardusecase.updateplayerinboard.UpdatePlayerInBoardUseCase;
import co.com.sofkau.usecase.boardusecase.usecard.UsecardUseCase;
import co.com.sofkau.usecase.boardusecase.wingame.WinGameUseCase;
import co.com.sofkau.usecase.gameusecase.winround.WinroundUseCase;
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
  private final UsecardUseCase usecardUseCase;
  private final ReallocateCardsUseCase reallocateCardsUseCase;
  private final TieBreakUseCase tieBreakUseCase;
  private final AddPlayerInBoardUseCase addPlayerInBoardUseCase;
  private final AddPlayerIdInBoardUseCase addPlayerIdInBoardUseCase;
  private final UpdatePlayerInBoardUseCase updatePlayerInBoardUseCase;

  public Mono<ServerResponse> listenPOSTCreateBoardUseCase(ServerRequest serverRequest) {
    return serverRequest
        .bodyToMono(Board.class)
        .flatMap(
            element ->
                ServerResponse.ok()
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
    return serverRequest
        .bodyToMono(Board.class)
        .flatMap(
            element ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updateboardUseCase.updateBoard(id, element), Board.class));
  }


  public Mono<ServerResponse> listenReallocateCardsUseCase(ServerRequest serverRequest) {
    var id = serverRequest.pathVariable("id");

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(reallocateCardsUseCase.reallocateCards(id), Player.class);
  }

  public Mono<ServerResponse> listenTieBreakUseCase(ServerRequest serverRequest) {
    var id = serverRequest.pathVariable("id");

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(tieBreakUseCase.tieBreak(id), Board.class);
  }

  public Mono<ServerResponse> listenUseCardUseCase(ServerRequest serverRequest) {
    var idCard = serverRequest.pathVariable("id");

    return serverRequest
        .bodyToMono(Board.class)
        .flatMap(
            element ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(usecardUseCase.useCard(idCard, element), Board.class));
  }

  public Mono<ServerResponse> listenAddPlayerInBoardUseCase(ServerRequest serverRequest) {
    var idPlayer = serverRequest.pathVariable("idplayer");

    return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(addPlayerInBoardUseCase.addPlayerInBord(idPlayer), Board.class);
  }

  public Mono<ServerResponse> listenAddPlayerIdInBoardUseCase(ServerRequest serverRequest) {
    var idPlayer = serverRequest.pathVariable("idplayer");

    return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(addPlayerIdInBoardUseCase.addPlayerIdInBord(idPlayer), Board.class);
  }

  public Mono<ServerResponse> listenUpdatePlayerInBoardUseCase(ServerRequest serverRequest) {
    var idBoard = serverRequest.pathVariable("idboard");

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(updatePlayerInBoardUseCase.addPlayerInBord(idBoard), Board.class);
  }
}
