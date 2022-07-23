package co.com.sofkau.model.board.gateways;

import co.com.sofkau.model.board.Board;;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.Player;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface BoardRepository {
    Mono<Board> save(Board board);
    Mono<Board> findById(String id);
    Mono<Void> delete(String id);
    Mono<Board> update(String id, Board board);
    Mono<String> winRound(Mono<Optional<Card>> win);
    Mono<Board> useCard(Board board);


}
