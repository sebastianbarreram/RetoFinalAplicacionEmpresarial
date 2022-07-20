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
    String playerId;
    String nickNAme;
    String email;
    Integer score;
    // hola
    List<Integer> pointsHistory = new ArrayList<>();
    List<GameCard> gameCardModels = new ArrayList<>();
}
