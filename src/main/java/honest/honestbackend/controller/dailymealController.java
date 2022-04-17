package honest.honestbackend.controller;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.User;
import honest.honestbackend.service.dailymealRepository;
import honest.honestbackend.service.dailymealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

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

        /*날짜 포맷 변경코드*/
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //Date date = new Date(sdf.format(dailymeal.getDatekey())); //시간 때문에 형식을 바꿈 00시로 바꿔줘야 함..
        //dailymeal.setDatekey(date);

        dailymealRepository.save(dailymeal);
        return "post 성공";
    }

    //public Dailymeal CheckDailyMealGet(String id, @DateTimeFormat(pattern = "yyyy/MM/dd") Date datekey){
    @ResponseBody
    @GetMapping("/checkDailyMeal.do")
    public Dailymeal CheckDailyMealGet(String id, Date datekey) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        //Date date = (Date) sdf.parse(datekey); //시간 때문에 형식을 바꿈 00시로 바꿔줘야 함..
        //dailymeal.setDatekey(date);

        Dailymeal dailymeal = dailymealRepository.findByDailymealId(id,datekey);
        if( dailymeal!= null ){
            System.out.println(dailymeal.toString());
            return dailymeal;
        }
        else{
            Dailymeal Dailymeal = new Dailymeal(id, datekey, 0, 0, 0, 0, 0, dailymealRepository.countAllBy()+1);
            dailymealRepository.save(Dailymeal);

            System.out.println(Dailymeal.toString());
            return Dailymeal;
        }

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
