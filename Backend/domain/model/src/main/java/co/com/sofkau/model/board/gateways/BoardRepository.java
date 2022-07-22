package co.com.sofkau.model.board.gateways;

import co.com.sofkau.model.board.Board;;
import co.com.sofkau.model.card.Card;
import reactor.core.publisher.Mono;

public interface BoardRepository {
    Mono<Board> save(Board board);
    Mono<Board> findById(String id);
    Mono<Void> delete(String id);
    Mono<Board> update(String id, Board board);

    Mono<Board>winRound(Mono<Board>win);
}
