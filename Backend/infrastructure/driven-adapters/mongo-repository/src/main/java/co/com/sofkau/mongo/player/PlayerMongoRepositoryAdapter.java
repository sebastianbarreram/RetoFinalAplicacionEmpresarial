package co.com.sofkau.mongo.player;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class PlayerMongoRepositoryAdapter extends AdapterOperations<Player, PlayerDocument, String, PlayerMongoDBRepository>
    implements PlayerRepository
{

    public PlayerMongoRepositoryAdapter(PlayerMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Player.class));
    }

    @Override
    public Mono<Void> delete(String id) {
        return deleteById(id);
    }

    @Override
    public Mono<Player> updatePlayer(String id, Player player) {
        player.setPlayerId(id);

        return  repository.save(
                new PlayerDocument(
                        player.getPlayerId(),
                        player.getNickName(),
                        player.getEmail(),
                        player.getScore(),
                        player.getPointsHistory(),
                        player.getCardModels())
        ).flatMap(element -> Mono.just(player));
    }

    @Override
    public Mono<Player> addPointsHistory(Player player) {

        return  repository.save(
                new PlayerDocument(
                        player.getPlayerId(),
                        player.getNickName(),
                        player.getEmail(),
                        player.getScore(),
                        player.getPointsHistory(),
                        player.getCardModels())
        ).flatMap(element -> Mono.just(player));
    }

    @Override
    public Mono<Player> addScore(Player player) {
        return repository.save(
                new PlayerDocument(
                        player.getPlayerId(),
                        player.getNickName(),
                        player.getEmail(),
                        player.getScore(),
                        player.getPointsHistory(),
                        player.getCardModels())
        ).flatMap(element -> Mono.just(player));
    }

  @Override
  public Mono<Player> reallocateCards(Player player) {
    return repository
        .save(
            new PlayerDocument(
                player.getPlayerId(),
                player.getNickName(),
                player.getEmail(),
                player.getScore(),
                player.getPointsHistory(),
                player.getCardModels()))
        .flatMap(element -> Mono.just(player));
    }
}
