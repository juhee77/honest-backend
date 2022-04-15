package honest.honestbackend.domain;
//https://techblog.woowahan.com/2595/
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dailymeal")
@IdClass(DailymealId.class)
public class Dailymeal implements Serializable {
    @Id
    @Column(name="userID")
    private String userId;

    @Id
    @Column(name="datekey")
    private Date dateKey;

    private int stepCount;
    private int calorie;
    private int protein;
    private int carbohydrate;
    private int fat;

    public Dailymeal(String userId, Date dateKey, int stepCount, int calorie, int protein, int carbohydrate, int fat) {
        this.userId = userId;
        this.dateKey = dateKey;
        this.stepCount = stepCount;
        this.calorie = calorie;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
    }

    public Dailymeal() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateKey() {
        return dateKey;
    }

    public void setDateKey(Date dateKey) {
        this.dateKey = dateKey;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }
}
