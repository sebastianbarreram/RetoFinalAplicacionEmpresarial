package co.com.sofkau.model.player;

import co.com.sofkau.model.gamecard.GameCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String playerId;
    private String nickName;
    private String email;
    private Integer score;

    private final List<Integer> pointsHistory = new ArrayList<>();
    //private List<GameCard> gameCardModels = new ArrayList<>();
}
