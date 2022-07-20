import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GameCardModel {

    String carId;
    int xp;
    // String nameDescrition;
    // String Characteristic;
    String Logo;

}
