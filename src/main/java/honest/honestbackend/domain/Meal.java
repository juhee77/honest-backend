package honest.honestbackend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "meal")
@IdClass(MealId.class)
public class Meal implements Serializable {
    @Id
    //@Column(name="useriD")
    private String userid;
    @Id
    //@Column(name="dailymealid")
    private int dailymealid;

    private int calorie;
    private int protein;
    private int carbohydrate;
    private int fat;
    private String mealname;

}
