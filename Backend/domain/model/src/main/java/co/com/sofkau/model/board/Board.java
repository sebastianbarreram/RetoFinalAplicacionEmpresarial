package co.com.sofkau.model.board;

import co.com.sofkau.model.card.Card;
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
public class Board {

    private String id;
<<<<<<< Updated upstream
    private Date time;

    private List<String> listWinRound;
=======
    private Integer time;
>>>>>>> Stashed changes
    private List<Card> listCard;
    private List<Player> listplayer ;
    private List<String> idplayers;

}
