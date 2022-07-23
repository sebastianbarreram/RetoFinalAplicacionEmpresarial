package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;

import co.com.sofkau.mongo.helper.AdapterOperations;
import co.com.sofkau.mongo.player.PlayerDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardMongoRepositoryAdapter extends AdapterOperations<Board, BoardDocument, String, BoardMongoDBRepository>
        implements BoardRepository {

    public BoardMongoRepositoryAdapter(BoardMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Board.class));
    }
    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Board> update(String id, Board board) {

        board.setId(id);
        return repository.save(new BoardDocument(board.getId(),board.getListCard(),board.getTime()))
                .flatMap(element -> Mono.just(board));
    }

    @Override
    public Mono<String> winRound(Mono<Optional<Card>> win) {
        return win.map(a->a.get().getPlayerId());
    }

    @Override
    public Mono<Board> useCard(Board board) {
        return Mono.just(board);
    }


}