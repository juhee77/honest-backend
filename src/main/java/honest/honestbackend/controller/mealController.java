package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.service.dailymealService;
import honest.honestbackend.service.mealRepository;
import honest.honestbackend.service.mealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class mealController {
    @Autowired
    honest.honestbackend.service.mealRepository mealRepository;
    @Autowired
    honest.honestbackend.service.mealService mealService;
    @Autowired
    honest.honestbackend.service.dailymealService dailymealService;

    @ResponseBody //dailymeal save to DB
    @PostMapping("/mealSave.do")
        public String mealSavePost(Map<String, ArrayList> map){
        System.out.println(map);
        if(map==null) System.out.println("??");
        else System.out.println("gg");

        ArrayList<Meal> mealList= new ArrayList<>();
        mealList=map.get("mealList");

        String userid;
        Date savetime;
        for(Meal meal : mealList){
            userid = meal.getUserid();
            savetime = meal.getSavetime();

            Dailymeal dailymeal = dailymealService.checkDailyMeal(userid,savetime);

            //meal.setDailymealid(dailymeal.getDailymealid()); // meal dailymeal의 키를 meal 데이터에서 가져와서 설정
            meal.setMealid(mealRepository.countAllBy()+1); //meal id설정
            //mealService.saveMeal(meal);
            mealRepository.save(meal);

            dailymeal.setCalorie(dailymeal.getCalorie()+ meal.getCalorie());
            dailymeal.setFat(dailymeal.getFat()+meal.getFat());
            dailymeal.setProtein(dailymeal.getProtein()+meal.getProtein());
            dailymeal.setCarbohydrate(dailymeal.getCarbohydrate()+meal.getCarbohydrate());

            dailymealService.saveDailyMeal(dailymeal);
            System.out.println("dailymeal 저장 !!! "); //없으면 새로 만들고 있으면 update 함

        }

        return "post 성공";
        //return null;
    }

/*
    @ResponseBody
    @GetMapping("/updateDailyMealInfo.do")
    public Dailymeal updateDailyMealInfo(Dailymeal dailymeal){

        return dailymeal;
    }
    */

    @ResponseBody
    @GetMapping("/mealtest.do")
    public void test(String s){
        mealService.mealTest();
    }

}
