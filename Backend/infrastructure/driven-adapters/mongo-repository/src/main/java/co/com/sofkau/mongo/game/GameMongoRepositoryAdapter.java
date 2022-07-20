package co.com.sofkau.mongo.game;

import co.com.sofkau.mongo.MongoDBRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameMongoRepositoryAdapter extends AdapterOperations<Object/* change for domain model */, Object/* change for adapter model */, String, MongoDBRepository>
// implements ModelRepository from domain
{

    public GameMongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Object.class/* change for domain model */));
    }
}
