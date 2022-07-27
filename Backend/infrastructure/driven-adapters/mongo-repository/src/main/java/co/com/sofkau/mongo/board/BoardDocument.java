package co.com.sofkau.mongo.board;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDocument {
    @Id
    private String id;

    private Integer time;
    private List<String> listWinRound;
    private List<Card> listCard;
    private List<Player> listplayer ;
    private List<String> idPlayers = new ArrayList<>();

}
