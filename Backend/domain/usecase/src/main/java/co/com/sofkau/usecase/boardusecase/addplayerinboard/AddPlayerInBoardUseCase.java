package co.com.sofkau.usecase.boardusecase.addplayerinboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddPlayerInBoardUseCase {

    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    public Mono<Board>addPlayerInBord(String idPlayer , Board board){

       var newBoard =  playerRepository.findById(idPlayer).
                           map(  player1 -> {

                               var listsPlayers = board.getListplayer();
                               var playerId = board.getIdplayers();

                                listsPlayers.add(player1);
                                playerId.add(player1.getPlayerId());

                               return  new Board(
                                       board.getId(),
                                       board.getTime(),
                                       board.getListWinRound(),
                                       board.getListCard(),
                                       listsPlayers,
                                       playerId
                               );
                           }).toFuture().join();


        return boardRepository.addplayerinboard(newBoard);
    }

}
