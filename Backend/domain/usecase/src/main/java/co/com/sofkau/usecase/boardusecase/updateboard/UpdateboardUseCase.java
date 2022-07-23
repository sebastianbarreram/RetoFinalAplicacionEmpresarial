package co.com.sofkau.usecase.boardusecase.updateboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateboardUseCase {
    private final BoardRepository boardRepository;
    public Mono<Board> updateBoard(String id, Board board){
        return boardRepository.update(id,board);
    }
}
