package co.com.sofkau.mongo.game;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface GameMongoDBRepository extends ReactiveMongoRepository<GameDocument, String>, ReactiveQueryByExampleExecutor<GameDocument> {
}
