package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.User;
import honest.honestbackend.service.dailymealRepository;
import honest.honestbackend.service.dailymealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

public class dailymealController {
    @Autowired
    dailymealRepository dailymealRepository;
    @Autowired
    dailymealService dailymealService;

/*
    @ResponseBody //dailymeal save to DB
    @PostMapping("/dailymealSave.do")
    public String userSavePost(Dailymeal dailymeal){
        if(dailymealRepository.findById(dailymeal.getUserId(), dailymeal.getDateKey())==null){
            dailymealRepository.save(dailymeal);
        }
        else{
            updateDailyMealInfo(dailymeal);
        }
        return "post 성공";
        //return null;
    }


    @ResponseBody
    @GetMapping("/updateDailyMealInfo.do")
    public Dailymeal updateDailyMealInfo(Dailymeal dailymeal){

        return dailymeal;
    }
    */
}
