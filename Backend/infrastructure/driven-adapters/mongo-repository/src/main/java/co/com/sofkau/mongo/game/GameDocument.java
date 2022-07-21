package co.com.sofkau.mongo.game;

import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDocument {
    @Id
    private String id;
    private Date time;
    private List<Player> playerModelList = new ArrayList<>();
}
