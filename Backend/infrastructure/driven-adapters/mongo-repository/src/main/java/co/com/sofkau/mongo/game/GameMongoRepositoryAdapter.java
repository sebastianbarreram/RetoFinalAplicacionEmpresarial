package co.com.sofkau.mongo.game;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.gamecard.gateways.GameRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class GameMongoRepositoryAdapter extends AdapterOperations<Game, GameDocument, String, GameMongoDBRepository>
 implements GameRepository{

    public GameMongoRepositoryAdapter(GameMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Game.class));
    }

    @Override
    public Mono<Void> delete(String id) {
        return deleteById(id);
    }

    @Override

    public Mono<Game> update(String id, Game game) {
        return update(id,game);
    }
}
