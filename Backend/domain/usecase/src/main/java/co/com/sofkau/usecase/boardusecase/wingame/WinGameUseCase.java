package co.com.sofkau.usecase.boardusecase.wingame;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class WinGameUseCase {
    private final BoardRepository boardRepository;
    private final GameRepository gameRepository;


    public Mono<String> winGame(String id){

        var playerId = gameRepository.findById(id)
                .map(e->e.getCardGamesList().stream()
                        .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2))
                .map(player -> player.get().getPlayerId());


        return  boardRepository.winGame(playerId);
    }
}
