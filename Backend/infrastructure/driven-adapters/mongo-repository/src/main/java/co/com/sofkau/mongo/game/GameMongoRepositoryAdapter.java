package co.com.sofkau.mongo.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.mongo.board.BoardDocument;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameMongoRepositoryAdapter
    extends AdapterOperations<Game, GameDocument, String, GameMongoDBRepository>
    implements GameRepository {

  public GameMongoRepositoryAdapter(GameMongoDBRepository repository, ObjectMapper mapper) {
    /**
     * Could be use mapper.mapBuilder if your domain model implement builder pattern
     * super(repository, mapper, d ->
     * mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build()); Or using mapper.map with
     * the class of the object model
     */
    super(repository, mapper, d -> mapper.map(d, Game.class));
  }

  @Override
  public Mono<Void> delete(String id) {
    return deleteById(id);
  }

  @Override
  public Mono<Game> updateGame(String id, Game game) {
    game.setId(id);

    return repository
        .save(
            new GameDocument(
                game.getId(),
                game.getNumberPlayers(),
                game.getPlayerModelList().stream().distinct().collect(Collectors.toList()),
                game.getCardGamesList()))
        .flatMap(element -> Mono.just(game));
  }


  @Override
  public Mono<Game> addPlayersInGame( Game game) {
    return repository
        .save(
            new GameDocument(
                game.getId(),
                game.getNumberPlayers(),
                game.getPlayerModelList(),
                game.getCardGamesList()))
        .flatMap(element -> Mono.just(game));
  }

  @Override
  public Mono<Game> addCardsInGame(Game game) {
    return repository
        .save(
            new GameDocument(
                game.getId(),
                game.getNumberPlayers(),
                game.getPlayerModelList(),
                game.getCardGamesList()))
        .flatMap(element -> Mono.just(game));
  }
}
