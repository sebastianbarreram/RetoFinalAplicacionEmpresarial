package co.com.sofkau.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.sofkau.usecase.playerusecase.addplayer.AddPlayerUseCase;
import co.com.sofkau.usecase.playerusecase.deleteplayer.DeletePlayerUseCase;
import co.com.sofkau.usecase.playerusecase.findplayer.FindPlayerUseCase;
import co.com.sofkau.usecase.playerusecase.listsplayers.ListsPlayersUseCase;
import co.com.sofkau.usecase.playerusecase.updateplayer.UpdatePlayerUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PlayerHandler {

    private final AddPlayerUseCase addPlayerUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final FindPlayerUseCase findPlayerUseCase;
    private final ListsPlayersUseCase listsPlayersUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(DtoPlayer.class)
                .flatMap(transformerPlayer -> addPlayerUseCase.addPlayer(transformerPlayer))
                .flatMap(player -> ServerResponse.ok()
                        .contentType(MediaType.APPICATION_JSON)
                        .body(addPlayerUseCase.addPlayer(player), DtoPlayer.class));

        // usecase.logic();
        // return ServerResponse.ok().bodyValue("");
    }

    /*
     * public Mono<ServerResponse> createHeroUseCase(ServerRequest serverRequest) {
     * return serverRequest.bodyToMono(Hero.class)
     * .flatMap(element -> createHeroUseCase.createHero(element))
     * .flatMap(element -> ServerResponse.ok()
     * .contentType(MediaType.APPLICATION_JSON)
     * .body(heroRepository.save(element), Hero.class));
     * }
     *
     * public Mono<ServerResponse> listAllUseCase(ServerRequest serverRequest) {
     * return ServerResponse.ok()
     * .contentType(MediaType.APPLICATION_JSON)
     * .body(heroRepository.findAll(), Hero.class);
     * }
     *
     * public Mono<ServerResponse> listForIdUseCase(ServerRequest serverRequest) {
     * var id = serverRequest.pathVariable("id");
     *
     * return ServerResponse.ok()
     * .contentType(MediaType.APPLICATION_JSON)
     * .body(heroRepository.findById(id), Hero.class);
     * }
     *
     * public Mono<ServerResponse> updateForHero(ServerRequest serverRequest) {
     * var id = serverRequest.pathVariable("id");
     *
     * return serverRequest.bodyToMono(Hero.class)
     * .flatMap(element -> ServerResponse.ok()
     * .contentType(MediaType.APPLICATION_JSON)
     * .body(heroRepository.update(id, element), Hero.class));
     * }
     *
     * public Mono<ServerResponse> deleteHero(ServerRequest serverRequest) {
     * var id = serverRequest.pathVariable("id");
     *
     * return ServerResponse.ok()
     * .contentType(MediaType.APPLICATION_JSON)
     * .body(heroRepository.delete(id), Hero.class);
     * }
     *
     */
}
