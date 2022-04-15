package honest.honestbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "meal")
@IdClass(MealId.class)
public class Meal implements Serializable {
    @Id
    private String userId;
    @Id
    private int dailymealId;
    private int calorie;
    private int protein;
    private int carvbohydrate;
    private int fat;
    private String mealName;

    public Meal(String userId, int dailymealId, int calorie, int protein, int carvbohydrate, int fat, String mealName) {
        this.userId = userId;
        this.dailymealId = dailymealId;
        this.calorie = calorie;
        this.protein = protein;
        this.carvbohydrate = carvbohydrate;
        this.fat = fat;
        this.mealName = mealName;
    }

    public Meal() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDailymealId() {
        return dailymealId;
    }

    public void setDailymealId(int dailymealId) {
        this.dailymealId = dailymealId;
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

    public int getCarvbohydrate() {
        return carvbohydrate;
    }

    public void setCarvbohydrate(int carvbohydrate) {
        this.carvbohydrate = carvbohydrate;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

}
