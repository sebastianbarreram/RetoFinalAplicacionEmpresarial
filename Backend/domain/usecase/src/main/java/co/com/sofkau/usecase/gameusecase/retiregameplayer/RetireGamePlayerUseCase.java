package co.com.sofkau.usecase.gameusecase.retiregameplayer;

import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RetireGamePlayerUseCase {
    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;
    private final PlayerRepository playerRepository;
    public Mono<Game> retireGamePlayer(String idPlayer){
       var newGame= gameRepository.findById("1");

        var board = newGame.
                game.getPlayerModelList().stream().filter(player-> player.equals(idPlayer));
        List<Card> cardsNew = game.getCardGamesList().stream().filter(card -> card.getPlayerId().equals(idPlayer)).collect(Collectors.toList());
        game.setCardGamesList(cardsNew);
        System.out.println(game);
       return gameRepository.retireGamePlayer(game);
    }
}
