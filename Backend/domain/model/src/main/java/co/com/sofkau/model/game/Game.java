package co.com.sofkau.model.game;
import co.com.sofkau.model.gamecard.GameCard;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String id;
    private Date time;
    private final List<Player> playerModelList = new ArrayList<>();
    // private List<Card> cardGamesList = new ArrayList<>();


    private final List<GameCard> gameCardModelList = new ArrayList<>();

}

