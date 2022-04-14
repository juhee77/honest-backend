package honest.honestbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URI;

@Getter @Setter
@ToString
@Entity
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


    public User(String id, String nickname, char sex, int age, int height, int weight, int activity_index, int target_calories, String profile) {
        this.id = id;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity_index = activity_index;
        this.target_calories = target_calories;
        this.profile=profile;
    }

    public User() {

    }


    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public char getSex(){
        return sex;
    }

    public void setSex(char sex){
        this.sex = sex;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height =height;
    }


    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight =weight;
    }



    public int getActivity_index(){
        return activity_index;
    }

    public void setActivity_index(int activity_index){
        this.activity_index =activity_index;
    }

    public int getTarget_calories(){
        return target_calories;
    }

    public void setTarget_calories(int target_calories){
        this.target_calories =target_calories;
    }

    public void setProfile(String profile){this.profile=profile;}
    public String getProfile(){ return profile;}

    public String pringStirng(){
        return  "user"+id+"  "+nickname+"   "+sex + "   " + getActivity_index();
    }



}
