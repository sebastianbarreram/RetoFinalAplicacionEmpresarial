package co.com.sofkau.usecase.boardusecase.gettablerobyid;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.game.Game;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GettablerobyidUseCase {
    private final BoardRepository boardRepository;
    public Mono<Board> listBoardId(String id) {
        return boardRepository.findById(id);
    }
}
