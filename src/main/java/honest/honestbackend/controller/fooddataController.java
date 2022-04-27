package honest.honestbackend.controller;

import honest.honestbackend.domain.FoodData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class fooddataController {
    @Autowired
    honest.honestbackend.service.fooddataService fooddataService;
    @Autowired
    honest.honestbackend.service.fooddataRepository fooddataRepository;

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

}
