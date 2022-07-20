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
    //Para simplificar no se tienen en cuenta estos atributos
    // String nameDescrition;
    // String Characteristic;
    String Logo;

}
