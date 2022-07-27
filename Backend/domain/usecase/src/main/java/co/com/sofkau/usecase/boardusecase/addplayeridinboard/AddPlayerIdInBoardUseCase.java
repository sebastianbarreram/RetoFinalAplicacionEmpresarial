package co.com.sofkau.usecase.boardusecase.addplayeridinboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AddPlayerIdInBoardUseCase {

    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    public Mono<Board>addPlayerIdInBord(String idPlayer){
        var board=boardRepository.findById("62de01f1ee60c664c3d720fb")
                .toFuture().join();

    var newBoard =
        playerRepository
            .findById(idPlayer)
            .map(
                player1 -> {

                  List<String> playerId = new ArrayList<>();

                  if(board.getIdPlayers() != null){
                         playerId = board.getIdPlayers();
                  }

                  playerId.add(idPlayer);
                  System.out.println(idPlayer);

                  return new Board(
                          board.getId(),
                      board.getTime(),
                      board.getListWinRound(),
                      board.getListCard(),
                      board.getListplayer(),
                      playerId.stream().distinct().collect(Collectors.toList())
                      );
                })
            .toFuture()
            .join();

        return boardRepository.addplayerinboard(newBoard);
    }
}
