package co.com.sofkau.usecase.gameusecase.retiregameplayer;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.usecase.gameusecase.listgamebyid.ListgamebyidUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RetireGamePlayerUseCase {
    private final GameRepository gameRepository;
    private final ListgamebyidUseCase listgamebyidUseCase;

    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;
    public Mono<Board> retireGamePlayer(String idPlayer){
       var newGame= listgamebyidUseCase.listGameId("1").toFuture().join();
        var listCardRound = newGame.getCardGamesList();
        var newboard = boardRepository.findById("62de01f1ee60c664c3d720fb");


        var newBoard = newboard
                        .map(
                                board -> {
                                    var newListCards =  board.getListCard().stream().filter(card -> !card.getPlayerId().equals(idPlayer)).collect(Collectors.toList());
                                    var newListPlayerIds =  board.getIdPlayers().stream().filter(playerId -> !playerId.equals(idPlayer)).collect(Collectors.toList());
                                    var newListPlayers =  board.getListplayer().stream().filter(player -> !player.getPlayerId().equals(idPlayer)).collect(Collectors.toList());

                                    return new Board(
                                            board.getId(),
                                            board.getTime(),
                                            board.getListWinRound(),
                                            newListCards,
                                            newListPlayers,
                                            newListPlayerIds);
                                })
                        .toFuture()
                        .join();

        return boardRepository.retireGamePlayer(newBoard) ;
    };
}
