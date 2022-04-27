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
    private long id;
    private String name;
    private double one_serving;//한번 제공량
    private double total_content; //총 제공량
    private double calorie;//칼로리
    private double moisture;//수분함량
    private double protein;//단백질
    private double fat;//지방
    private double carbohydrate;//탄수화물
    private double total_sugar;//당
    private double sucrose; //자당
    private double glucose; //포도당
    private double fructose; //과당
    private double lactose; //유당
    private double maltose; //엿당
    private double total_dietary_fiber;//식이섬유
    private double calcium; //칼슘
    private double iron;//철
    private double magnesium;//마그네슘
    private double in;//인
    private double potassium;//칼륨
    private double sodium;//나트륨
    private double zinc;//아연
    private double copper;//구리
    private double manganese;//망가니즈
    private double vitamin_b1;//비타민B1
    private double vitamin_b2;//비타민B2
    private double vitamin_c;//비타민C
    private double cholesterol;//콜레스테롤
    private double total_saturated_fatty_acids;//포화지방산
    private double trans_fatty_acids;//트랜스지방
    private double several_times;//???
    private double caffeine;//카페인

}
