package honest.honestbackend.domain;
//https://techblog.woowahan.com/2595/
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
@Table(name = "dailymeal")
@IdClass(DailymealId.class)
public class Dailymeal implements Serializable {
    @Id
    //@Column(name="userid")
    private String userid;

    @Id
    //@Column(name="datekey")
    private Date datekey;

    private int stepcount;
    private int calorie;
    private int protein;
    private int carbohydrate;
    private int fat;
    private long dailymealid;

}
