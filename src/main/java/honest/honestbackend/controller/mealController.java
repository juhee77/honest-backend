package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.service.mealRepository;
import honest.honestbackend.service.mealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mealController {
    @Autowired
    honest.honestbackend.service.mealRepository mealRepository;
    @Autowired
    honest.honestbackend.service.mealService mealService;

    @ResponseBody //dailymeal save to DB
    @PostMapping("/mealSave.do")
    public String userSavePost(Meal Meal){
        //if(dailymealRepository.findById(dailymeal.getUserId(), dailymeal.getDateKey())==null){
        mealRepository.save(Meal);
        //}
        //else{
        //    updateDailyMealInfo(dailymeal);
        //}
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
