package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.User;
import honest.honestbackend.service.dailymealRepository;
import honest.honestbackend.service.dailymealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class dailymealController {
    @Autowired
    dailymealRepository dailymealRepository;
    @Autowired
    dailymealService dailymealService;


    @ResponseBody //dailymeal save to DB
    @PostMapping("/dailymealSave.do")
    public String dailyMealSavePost(Dailymeal dailymeal){
        dailymeal.setDailymealid(dailymealRepository.countAllBy()+1); //dailymeal은 count에서 하나씩 증가된 코드

            dailymealRepository.save(dailymeal);
        return "post 성공";
    }

/*
    @ResponseBody
    @GetMapping("/updateDailyMealInfo.do")
    public Dailymeal updateDailyMealInfo(Dailymeal dailymeal){

        return dailymeal;
    }
    */


    @ResponseBody
    @GetMapping("/test.do")
    public void test(String s){
        dailymealService.test();
    }

}
