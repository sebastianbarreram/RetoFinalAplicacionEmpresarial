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
    Mono<Card> winRound(Mono<Card> playerId);
    Mono<String> winGame(Mono<String> playerId);
    Mono<Board> useCard(Board board);
    Mono<Board> retireGamePlayer(Board board);
    Mono<Board> addplayerinboard(Board board);

    Mono<Board> updatePlayerInBoard(Board board);

}
