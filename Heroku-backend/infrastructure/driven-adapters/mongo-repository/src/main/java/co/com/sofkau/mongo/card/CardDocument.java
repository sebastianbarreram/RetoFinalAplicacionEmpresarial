package co.com.sofkau.mongo.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDocument {
    @Id
    private String cardId;
    private Integer xp;
    private String image;
    private Boolean hidden;
    private String playerId;
}
