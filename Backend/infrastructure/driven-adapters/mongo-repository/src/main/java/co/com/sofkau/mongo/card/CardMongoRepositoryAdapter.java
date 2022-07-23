package co.com.sofkau.mongo.card;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        return repository.deleteById(id);
    }

    @Override
    public Mono<Card> update(String id, Card card) {
        card.setCardId(id);
        return repository
                .save(new CardDocument(card.getCardId(), card.getXp(), card.getImage(),card.getHidden(),card.getPlayerId()))
                .flatMap(element -> Mono.just(card));
    }

    @Override
    public Flux<Card> randomCards(List<Card> newCards) {
        return Flux.fromIterable(newCards);
    }

    @Override
    public Flux<Card> findByPlayerId(Flux<Card> playerCards) {
        return playerCards;
    }
}