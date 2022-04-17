package honest.honestbackend.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;

    private String nickname;
    private char sex;
    private Integer age;
    private Integer weight;
    private Integer height;
    private Integer activity_index;
    private Integer target_calories;
    private String profile;


}
