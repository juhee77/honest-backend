package honest.honestbackend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
    private long dailymealid;
    @Id
    private long mealid;

    private int calorie;
    private int protein;
    private int carbohydrate;
    private int fat;
    private String mealname;
    private String mealphoto;
    private Date savetime;
    private int timeflag;
    private long fooddataid;

}
