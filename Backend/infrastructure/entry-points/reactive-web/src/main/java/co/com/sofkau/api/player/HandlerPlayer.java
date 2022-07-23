package co.com.sofkau.api.player;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.usecase.deleteplayer.DeletePlayerUseCase;
import co.com.sofkau.usecase.playerusecase.addplayer.AddPlayerUseCase;
import co.com.sofkau.usecase.playerusecase.addpointshistory.AddPointsHistoryUseCase;
import co.com.sofkau.usecase.playerusecase.addscore.AddScoreUseCase;
import co.com.sofkau.usecase.playerusecase.findplayer.FindPlayerUseCase;
import co.com.sofkau.usecase.playerusecase.listsplayers.ListsPlayersUseCase;
import co.com.sofkau.usecase.boardusecase.reallocatecards.ReallocateCardsUseCase;
import co.com.sofkau.usecase.playerusecase.updateplayer.UpdatePlayerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerPlayer {

  private final AddPlayerUseCase addPlayerUseCase;
  private final ListsPlayersUseCase listsPlayersUseCase;
  private final UpdatePlayerUseCase updatePlayerUseCase;
  private final FindPlayerUseCase findPlayerUseCase;
  private final DeletePlayerUseCase deletePlayerUseCase;
  private final AddPointsHistoryUseCase addPointsHistoryUseCase;
  private final AddScoreUseCase addScoreUseCase;
private final ReallocateCardsUseCase reallocateCardsUseCase;
  public Mono<ServerResponse> listenPostAddPlayerUseCase(ServerRequest serverRequest) {

    return serverRequest
        .bodyToMono(Player.class)
        .flatMap(
            player ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(addPlayerUseCase.addPlayer(player), Player.class));
  }

  public Mono<ServerResponse> listenListAllPlayersUseCase(ServerRequest serverRequest) {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(listsPlayersUseCase.listsPlayers(), Player.class);
  }

   public Mono<ServerResponse> listenUpdatePlayerUseCase(ServerRequest serverRequest) {
   var id = serverRequest.pathVariable("id");

   return serverRequest.bodyToMono(Player.class)
             .flatMap(element -> ServerResponse.ok()
             .contentType(MediaType.APPLICATION_JSON)
             .body(  updatePlayerUseCase.updatePlayer(id, element), Player.class));
   }
  public Mono<ServerResponse> listenDeletePlayerUseCase(ServerRequest serverRequest) {
    var id = serverRequest.pathVariable("id");

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(deletePlayerUseCase.deletePlayer(id), Player.class);
  }


   public Mono<ServerResponse> listenListPlayerByIdUseCase(ServerRequest serverRequest) {
   var id = serverRequest.pathVariable("id");
   return ServerResponse.ok()
   .contentType(MediaType.APPLICATION_JSON)
   .body(findPlayerUseCase.findPlayer(id), Player.class);
   }

   public Mono<ServerResponse> listenaddPointsHistoryUseCase(ServerRequest serverRequest) {
       var points = serverRequest.pathVariable("points");
      return serverRequest.bodyToMono(Player.class)
               .flatMap(player -> ServerResponse.ok()
                       .contentType(MediaType.APPLICATION_JSON)
                       .body(  addPointsHistoryUseCase.addpointshistory( points, player), Player.class));
   }

   public Mono<ServerResponse> listenaddScoreUseCase(ServerRequest serverRequest) {
       var points = serverRequest.pathVariable("score");

       return serverRequest.bodyToMono(Player.class)
               .flatMap(player -> ServerResponse.ok()
                       .contentType(MediaType.APPLICATION_JSON)
                       .body(  addScoreUseCase.addScore( points, player), Player.class));
   }

}
