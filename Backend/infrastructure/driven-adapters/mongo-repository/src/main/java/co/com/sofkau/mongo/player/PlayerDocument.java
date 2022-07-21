package co.com.sofkau.mongo.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.sofkau.model.gamecard.GameCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PlayerDocument
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDocument {

    @Id
    private String playerId;

    private String nickName;
    private String email;
    private Integer score;

    private List<Integer> pointsHistory = new ArrayList<>();
    private List<GameCard> gameCardModels = new ArrayList<>();

}
