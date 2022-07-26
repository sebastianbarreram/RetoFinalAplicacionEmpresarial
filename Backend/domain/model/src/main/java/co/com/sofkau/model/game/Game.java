package co.com.sofkau.model.game;
import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private String id;
    private Integer numberPlayers;
    private List<String> playerModelList = new ArrayList<>();
    private List<Card> cardGamesList = new ArrayList<>();
    //private List<Board> Board = new ArrayList<>();

}

