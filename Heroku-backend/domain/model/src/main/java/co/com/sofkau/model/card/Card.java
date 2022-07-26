package co.com.sofkau.model.card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String cardId;
    private Integer xp;
    private String image;
    private Boolean hidden;
    private String playerId;
}
