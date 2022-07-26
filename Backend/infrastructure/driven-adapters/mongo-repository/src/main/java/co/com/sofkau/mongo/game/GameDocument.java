package co.com.sofkau.mongo.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDocument {
    @Id
    private String id;
    private Integer numberPlayers;
    private List<String> playerModelList = new ArrayList<>();
    private List<Card> cardGamesList = new ArrayList<>();
    //private List<Board> Board = new ArrayList<>();
}
