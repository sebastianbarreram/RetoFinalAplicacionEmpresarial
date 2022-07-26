package co.com.sofkau.usecase.boardusecase.usecard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UsecardUseCase {
  private final BoardRepository boardRepository;
  private final CardRepository cardRepository;

  public Mono<Board> useCard(String id, Board board) {

    var newBoard =
        cardRepository
            .findById(id)
            .map(
                card -> {
                  List<Card> listCards = board.getListCard();

                  listCards.add(card);

                  return new Board(
                      board.getId(),
                      board.getTime(),
                      board.getListWinRound(),
                      listCards,
                      board.getListplayer(),
                      board.getIdPlayers());
                }).toFuture().join();

    return boardRepository.useCard(newBoard);
  }
}
