package honest.honestbackend.controller;

import honest.honestbackend.domain.FoodData;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.service.mealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Controller
public class fooddataController {
    @Autowired
    honest.honestbackend.service.fooddataService fooddataService;
    @Autowired
    honest.honestbackend.service.fooddataRepository fooddataRepository;
    @Autowired
    mealRepository mealRepository;

    @ResponseBody
    @GetMapping("/selectFoodName.do")
    public List<FoodData> checkFoodNameGet(String name){
        System.out.println(name);
        if(fooddataRepository.selectByItem(name)!=null){
            //System.out.println("데이터있음");
            List<FoodData> food = fooddataRepository.selectByItem(name);
            return food;
        }
        else {
            System.out.println("데이터 없음");
            return null;
        }
    }

    @ResponseBody
    @GetMapping("/selectFoodFromMeal.do")
    public List<FoodData> FoodFromMealGet(String userid, Date savetime, int timeflag){
        List<Meal> mealList=mealRepository.selectByItem(userid, savetime, timeflag);
        List<FoodData> food=new ArrayList<>();
        for(Meal meal : mealList){
            food.add(fooddataRepository.findById(meal.getFooddataid()));
        }
        //System.out.println(food);
        return food;
    }

    @ResponseBody
    @GetMapping("/selectFoodFromFoodName")
    public FoodData FoodFromFoodNameGet(String name){
        FoodData food=null;

        if(fooddataRepository.selectByName(name)!=null) {
            food = fooddataRepository.selectByName(name);
        }
        else{
            if(fooddataRepository.selectByItem(name)!=null){
                List<FoodData> foodList = fooddataRepository.selectByItem(name);
                food=foodList.get(0);//첫번째 값
            }
        }
        System.out.println(food.getName());
        return food;
    }


}
