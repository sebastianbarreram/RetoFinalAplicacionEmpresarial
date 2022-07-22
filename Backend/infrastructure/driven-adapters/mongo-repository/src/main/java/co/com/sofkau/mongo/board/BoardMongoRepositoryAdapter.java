package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.mongo.card.CardDocument;
import co.com.sofkau.mongo.card.CardMongoDBRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
        return null;
    }

    @Override
    public Mono<Board> winRound(Mono<Board> win) {
        return win;
    }


}