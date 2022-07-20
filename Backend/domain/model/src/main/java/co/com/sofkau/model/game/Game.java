package co.com.sofkau.model.game;
import co.com.sofkau.model.card.GameCard;
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
    Date time;
    List<Player> playerModelList = new ArrayList<>();
    List<GameCard> gameCardModelList = new ArrayList<>();

}

