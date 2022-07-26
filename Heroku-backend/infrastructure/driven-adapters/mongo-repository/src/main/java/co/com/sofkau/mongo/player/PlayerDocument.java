package co.com.sofkau.mongo.player;

import java.util.ArrayList;
import java.util.List;

import co.com.sofkau.model.card.Card;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDocument {

    @Id
    private String playerId;
    private String nickName;
    private String email;
    private Integer score;
    private List<Integer> pointsHistory = new ArrayList<>();
    private List<Card> cardModels = new ArrayList<>();

}
