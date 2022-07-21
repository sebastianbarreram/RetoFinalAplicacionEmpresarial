package co.com.sofkau.mongo.player;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface PlayerMongoDBRepository extends ReactiveMongoRepository<PlayerDocument, String>, ReactiveQueryByExampleExecutor<PlayerDocument> {
}
