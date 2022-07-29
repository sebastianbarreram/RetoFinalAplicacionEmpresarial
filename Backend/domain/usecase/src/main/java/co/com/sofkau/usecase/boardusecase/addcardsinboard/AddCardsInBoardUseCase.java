package co.com.sofkau.usecase.boardusecase.addcardsinboard;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddCardsInBoardUseCase {

    private final BoardRepository boardRepository;
  private final CardRepository cardRepository;
  private final PlayerRepository playerRepository;
  private final GameRepository gameRepository;
  public Mono<Game> addCardsInGame(String idCard) {


      var game = gameRepository.findById("1").toFuture().join();

      var newGame =  boardRepository.findById("62de01f1ee60c664c3d720fb").map(
              board -> {

                              var card = board.getListCard().stream().filter (card1 -> card1.getCardId().equals(idCard)).reduce( (a, b) -> a ).get();


                              var listCards = game.getCardGamesList();
                               listCards.add(card);

                                  return new Game(
                                          game.getId(),
                                          game.getNumberPlayers(),
                                          game.getPlayerModelList(),
                                          listCards
                                  );
                          }).toFuture().join();

    return gameRepository.addCardsInGame(newGame);
  }
}
