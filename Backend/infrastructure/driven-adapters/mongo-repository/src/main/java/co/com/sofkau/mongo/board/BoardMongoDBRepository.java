package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.mongo.card.CardDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface BoardMongoDBRepository extends ReactiveMongoRepository<BoardDocument, String>, ReactiveQueryByExampleExecutor<BoardDocument> {
}
