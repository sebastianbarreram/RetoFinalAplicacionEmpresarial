package co.com.sofkau.api;

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
public class DtoPlayer {
    String playerId;
    String nickName;
    String email;
    Integer score;

    List<Integer> pointsHistory = new ArrayList<>();
    List<GameCard> gameCardModels = new ArrayList<>();
}
