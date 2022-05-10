package honest.honestbackend.controller;

import honest.honestbackend.domain.FoodData;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.service.dailymealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        int timeflag;

        userid = meal.getUserid();
        savetime = meal.getSavetime();
        dailymealid=meal.getDailymealid();
        timeflag=meal.getTimeflag();//식단position

        //meal.setDailymealid(dailymeal.getDailymealid()); // meal dailymeal의 키를 meal 데이터에서 가져와서 설정
        //meal.setMealid(mealRepository.countAllBy()+meal.getMealid()); //meal id설정
        //mealService.saveMeal(meal);
        mealRepository.save(meal);
        //List<Meal> mealList = mealRepository.findBymealId(userid,dailymealid);

        //List<Meal> mealList=mealRepository.selectByItem(userid, savetime, timeflag);
        //dailymealService.updateDailyMeal(userid, savetime , mealList);

        //System.out.println("#########"+meal.getIntake());
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

    @ResponseBody
    @GetMapping("/deleteMeal.do")
    public void deleteMealGet(String userid, Date savetime, int timeflag){//userid, (dailymealid) , savetime, timeflag
        int calorie=0, protein=0, fat=0, carbohydrate=0;

        if(!mealRepository.selectByItem(userid, savetime, timeflag).isEmpty()){
            /*
            List<Meal> mealList=mealRepository.selectByItem(userid, savetime, timeflag);
            해당 날짜, position에 총 탄단지가 얼마인지
            for(Meal meal:mealList){
                calorie+=(int)(meal.getCalorie()*meal.getIntake());
                protein+=(int)(meal.getProtein()*meal.getIntake());
                fat+=(int)(meal.getFat()*meal.getIntake());
                carbohydrate+=(int)(meal.getCarbohydrate()*meal.getIntake());
            }*/

            mealRepository.deleteByItem(userid,savetime,timeflag); //삭제하고 다시 저장하기 위함

        }
        //dailymealService.deleteDailyMeal(userid, savetime, calorie, protein, fat, carbohydrate);

    }

    @ResponseBody
    @GetMapping("/InitPositionMeal.do")
    public void InitPositionMealGet(String userid, Date savetime, int timeflag) {//userid, (dailymealid) , savetime, timeflag
        if (!mealRepository.selectByItem(userid, savetime, timeflag).isEmpty()) {
            mealRepository.deleteByItem(userid, savetime, timeflag);
        }
        List<Meal> ml = mealRepository.selectBysaveTime(userid, savetime);
        dailymealService.updateDailyMeal(userid, savetime, ml);

        int flag = timeflag + 1;
            for (; ; ) {
                List<Meal> mealList = mealRepository.selectByItem(userid, savetime, flag);
                if (!mealList.isEmpty()) {
                    for (Meal meal : mealList) {
                        System.out.println(meal.getMealname());
                        meal.setTimeflag(meal.getTimeflag() - 1);//위치 하나씩 줄이기
                        mealRepository.save(meal);
                    }
                    flag++;
                } else break;
            }
    }
    @ResponseBody
    @GetMapping("/selectMeal.do")
    public List<Meal> selectMeal(String userid, Date savetime, int timeflag){
        List<Meal> mealList=mealRepository.selectByItem(userid, savetime, timeflag);
        return mealList;
    }

    @ResponseBody
    @GetMapping("/maxTimeFlag.do")
    public Integer maxTimeFlag(String userid, Date savetime){
        int timeflag=0;
        if(!mealRepository.selectBysaveTime(userid, savetime).isEmpty())
            timeflag=mealRepository.maxTimeFlag(userid, savetime);
        else
            timeflag=0;
        //System.out.println(timeflag);
        return timeflag;
    }

/*
    @ResponseBody
    @GetMapping("/updateDailyMealInfo.do")
    public Dailymeal updateDailyMealInfo(Dailymeal dailymeal){

        return dailymeal;
    }
    */

    //해당 날짜의 섭취음식 모두 출력
    @ResponseBody
    @GetMapping("/selectOneDayFood.do")
    public List<Meal> selectOneDayFood(String userid, Date savetime){
        List<Meal> mealList = mealRepository.selectBysaveTime(userid, savetime);
        return mealList;
    }



    @ResponseBody
    @GetMapping("/mealtest.do")
    public void test(String s){
        mealService.mealTest();
    }



}
