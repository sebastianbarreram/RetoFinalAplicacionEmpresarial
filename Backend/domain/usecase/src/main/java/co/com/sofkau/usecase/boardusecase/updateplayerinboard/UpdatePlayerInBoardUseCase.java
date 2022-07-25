package co.com.sofkau.usecase.boardusecase.updateplayerinboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UpdatePlayerInBoardUseCase {

  private final BoardRepository boardRepository;
  private final PlayerRepository playerRepository;
  private final GetCardsUseCase getCardsUseCase;
  private final CardRepository cardRepository;

  public Mono<Board> addPlayerInBord(String idBoard) {

    var board = boardRepository.findById(idBoard);

    var listPlayerId =
        board.map(
            board1 -> {
              return board1.getIdPlayers().stream()
                      .map( player ->   player).collect(Collectors.toList());
            }).toFuture().join();

    var listPlayers = playerRepository.findAll().collectList().toFuture().join();

    var newListPlayers = listPlayers.stream()
            .filter( list-> listPlayerId.contains(list.getPlayerId())).collect(Collectors.toList());

    var newBoard = board.map( board1 ->{
        return new Board(
                board1.getId(),
                board1.getTime(),
                board1.getListWinRound(),
                board1.getListCard(),
                newListPlayers,
                board1.getIdPlayers());
            }
    ).toFuture().join();

    return boardRepository.addplayerinboard(newBoard);
  }
}
