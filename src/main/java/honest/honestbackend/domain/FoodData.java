package honest.honestbackend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "fooddata")
public class FoodData {

    @Id
    private Long id;

    private String name;
    private double one_serving;
    private double total_content;
    private double calorie;
    private double moisture;
    private double protein;
    private double fat;
    private double carbohydrate;
    private double total_sugar;
    private double sucrose;
    private double glucose;
    private double fructose;
    private double lactose;
    private double maltose;
    private double total_dietary_fiber;
    private double calcium;
    private double iron;
    private double magnesium;
    private double in;
    private double potassium;
    private double sodium;
    private double zinc;
    private double copper;
    private double manganese;
    private double vitamin_b1;
    private double vitamin_b2;
    private double vitamin_c;
    private double cholesterol;
    private double total_saturated_fatty_adds;
    private double trans_fatty_acids;
    private double several_times;
    private double caffeine;

}
