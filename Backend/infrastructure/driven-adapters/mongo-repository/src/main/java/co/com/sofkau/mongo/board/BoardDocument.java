package co.com.sofkau.mongo.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDocument {
    @Id
    private String id;
    private String idCard;
    private Date time;
}
