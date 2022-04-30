package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.service.dailymealRepository;
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
import java.util.List;
import java.util.Map;

@Controller
public class mealController {
    @Autowired
    honest.honestbackend.service.mealRepository mealRepository;
    @Autowired
    honest.honestbackend.service.mealService mealService;
    @Autowired
    honest.honestbackend.service.dailymealService dailymealService;
    @Autowired
    dailymealRepository dailymealRepository;

    @ResponseBody
    @PostMapping("/mealSave.do")
    public String mealSavePost(Meal meal){

        System.out.println(meal.getMealname());
        String userid;
        Date savetime;
        long dailymealid;

        userid = meal.getUserid();
        savetime = meal.getSavetime();
        dailymealid=meal.getDailymealid();

        //meal.setDailymealid(dailymeal.getDailymealid()); // meal dailymeal의 키를 meal 데이터에서 가져와서 설정
        meal.setMealid(mealRepository.countAllBy()+meal.getMealid()); //meal id설정
        //mealService.saveMeal(meal);
        mealRepository.save(meal);
        List<Meal> mealList = mealRepository.findBymealId(userid,dailymealid);

        dailymealService.updateDailyMeal(userid, savetime , mealList);
        /*
        Dailymeal dailymeal = dailymealService.checkDailyMeal(userid,savetime);
        dailymeal.setCalorie(dailymeal.getCalorie()+meal.getCalorie());
        dailymeal.setFat(dailymeal.getFat()+meal.getFat());
        dailymeal.setProtein(dailymeal.getProtein()+meal.getProtein());
        dailymeal.setCarbohydrate(dailymeal.getCarbohydrate()+meal.getCarbohydrate());
        dailymealRepository.save(dailymeal);
        */

        //System.out.println("dailymeal 저장 !!! "); //없으면 새로 만들고 있으면 update 함

        return "";
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
