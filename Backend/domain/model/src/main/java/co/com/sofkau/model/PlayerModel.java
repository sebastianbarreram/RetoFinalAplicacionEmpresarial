
package co.com.sofkau.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PlayerModel {
        String playerId;
        String nickNAme;
        String email;
        Integer score;

        List<Integer> pointsHistory = new ArrayList<>();
        List<GameCardModel> gameCardModels = new ArrayList<>();

}
