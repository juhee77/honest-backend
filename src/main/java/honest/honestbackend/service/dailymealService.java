package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.DailymealId;
import honest.honestbackend.domain.Meal;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Service
public class dailymealService {
    @Autowired
    dailymealRepository dailymealRepository;

    public void saveDailyMeal(Dailymeal dailymeal){
        System.out.println("dailymeal 업데이트 or 생성 ");
        dailymealRepository.save(dailymeal); //save는 insert, update 둘 다 가능하다
    }

    public void deleteDailyMeal(String userid, Date datekey, int calorie, int protein, int fat, int carbohydrate){
        Dailymeal dailymeal = checkDailyMeal(userid, datekey);

        dailymeal.setCalorie(dailymeal.getCalorie()-calorie);
        dailymeal.setFat(dailymeal.getFat()-fat);
        dailymeal.setProtein(dailymeal.getProtein()-protein);
        dailymeal.setCarbohydrate(dailymeal.getCarbohydrate()-carbohydrate);

        dailymealRepository.save(dailymeal);
    }

    public void updateDailyMeal(String userid, Date datekey, List<Meal> mealList){
        Dailymeal dailymeal = checkDailyMeal(userid, datekey);
        int calorie=0, protein=0, fat=0, carbohydrate=0;
        /*
        int calorie=dailymeal.getCalorie();
        int protein=dailymeal.getProtein();
        int fat=dailymeal.getFat();
        int carbohydrate=dailymeal.getCarbohydrate();*/

        for(Meal meal:mealList){
            calorie+=(int)(meal.getCalorie()*meal.getIntake());
            protein+=(int)(meal.getProtein()*meal.getIntake());
            fat+=(int)(meal.getFat()*meal.getIntake());
            carbohydrate+=(int)(meal.getCarbohydrate()*meal.getIntake());
        }

        dailymeal.setCalorie(calorie);
        dailymeal.setFat(fat);
        dailymeal.setProtein(protein);
        dailymeal.setCarbohydrate(carbohydrate);

        dailymealRepository.save(dailymeal);
    }

    public Dailymeal checkDailyMeal(String id, Date datekey){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        //Date date = new Date(sdf.format(datekey)); //시간 때문에 형식을 바꿈 00시로 바꿔줘야 함..
        Dailymeal dailymeal = dailymealRepository.findByDailymealId(id, datekey);

        //System.out.println(dailymeal2.toString());
        if(dailymeal==null){ //TODO: 나중에 이 부분은 생성된 날짜만 기록되어 있어야 하니까 생략하고 ( NULL로 리턴해서 안드로이드에서 해당날짜에 대한 정보는 없습니다로 출력하도록 해야함)
            System.out.println("중복없음!");
            Dailymeal Dailymeal = new Dailymeal(id, datekey, 0, 0, 0, 0, 0, dailymealRepository.countAllBy()+1);
            //dailymealRepository.save(Dailymeal); // 만약 없으면 새로 만들기 , make new dailymeal
            System.out.println(Dailymeal.toString());
            return Dailymeal;
        }
        else{
            System.out.println("중복있음!");
            System.out.println(dailymeal.toString());
            return dailymeal;

        }

    }

    public void updateStepCount(String userid, Date datekey, int stepCount){
        Dailymeal dailymeal = dailymealRepository.findByDailymealId(userid, datekey);
        dailymeal.setStepcount(stepCount);
        dailymealRepository.save(dailymeal);
    }

    public void test(){
        System.out.println(dailymealRepository.findAll().toString());
    }

    //public void setId(Dailymeal dailymeal){
    //    int count = dailymealRepository.countAllBy();
    //}

}