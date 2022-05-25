package honest.honestbackend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
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
    @Lob
    @Column(name = "mealphoto", columnDefinition="LONGBLOB")
    private String mealphoto;
    private Date savetime;
    private int timeflag;
    private long fooddataid;
    private double intake;//인분

}
