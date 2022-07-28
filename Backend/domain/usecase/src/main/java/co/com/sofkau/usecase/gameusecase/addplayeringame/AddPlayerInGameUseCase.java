package co.com.sofkau.usecase.gameusecase.addplayeringame;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AddPlayerInGameUseCase {

  private final BoardRepository boardRepository;
  private final PlayerRepository playerRepository;
  private final GameRepository gameRepository;

  public Mono<Game> addPlayerInGame(String idPlayer) {

    var game = gameRepository.findById("1").toFuture().join();

    var newGame = playerRepository.findById(idPlayer).map(
            player1 -> {
                var listPlayersId = game.getPlayerModelList();

                listPlayersId.add(player1.getPlayerId());

                return new Game(
                      game.getId(),
                      game.getNumberPlayers(),
                      listPlayersId.stream().distinct().collect(Collectors.toList()),
                      game.getCardGamesList()
                  );
               }
            ).toFuture().join();

    return gameRepository.addPlayersInGame(newGame);
  }
}
