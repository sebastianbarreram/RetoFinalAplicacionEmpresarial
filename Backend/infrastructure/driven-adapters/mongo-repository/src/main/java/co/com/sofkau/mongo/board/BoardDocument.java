package co.com.sofkau.mongo.board;

import co.com.sofkau.model.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private List<Card> listCard;
    private Date time;
}