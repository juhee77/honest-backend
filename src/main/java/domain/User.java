package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) ////MySQL의 AUTO_INCREMENT
    private String id;
    private String nickname;
    private char sex;
    private Integer age;
    private Integer height;
    private Integer actvity_index;
    private Integer target_calories;
    private byte[] profile;

}
