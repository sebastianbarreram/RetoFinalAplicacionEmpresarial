package co.com.sofkau.mongo.card;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface CardMongoDBRepository extends ReactiveMongoRepository<CardDocument, String>, ReactiveQueryByExampleExecutor<CardDocument> {
}
