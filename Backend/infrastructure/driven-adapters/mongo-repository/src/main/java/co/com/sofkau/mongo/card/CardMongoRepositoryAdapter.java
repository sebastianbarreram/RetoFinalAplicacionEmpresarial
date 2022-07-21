package co.com.sofkau.mongo.card;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CardMongoRepositoryAdapter extends AdapterOperations<Card, CardDocument, String, CardMongoDBRepository>
        implements CardRepository {

    public CardMongoRepositoryAdapter(CardMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Card.class));
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }

    @Override
    public Mono<Card> update(String id, Card card) {
        return null;
    }
}