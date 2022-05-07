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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    @ResponseBody
    @GetMapping("/checkWeeklyMeal.do")
    public List<Dailymeal> checkWeeklyMeal(String id, Date startDate, Date endDate) throws ParseException {

        //시작이 월요일 부터임(받는 데이터가)
        List<Dailymeal> beforeWeeklyDailyMeals = dailymealRepository.findByWeeklymealId(id, startDate,endDate);

        //일주일 데이터가 있을수도 있고 없을수도 없는 데이터(처리전 저장부)
        List<Dailymeal> weeklyDailyMeals = new ArrayList<Dailymeal>();
        //처리후 저장부
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int key=0; //hash size 만큼 돌기위해서
        /*날짜 포맷 변경코드//*///SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");if(sdf.format(tempDate).equals(sdf.format(date))){

        if(beforeWeeklyDailyMeals.isEmpty()){
            Date date = new Date(cal.getTimeInMillis());
            for(int i=0;i<7;i++){
                weeklyDailyMeals.add(new Dailymeal(id, date ,0, 0, 0, 0, 0, -11));
            }
            cal.add(Calendar.DATE,1);//하루씩 더해감
        }
        else{
            for(int i=0;i<7;i++){ //일주일
                Date tempDate =  beforeWeeklyDailyMeals.get(key).getDatekey(); //db에 있는 날짜

                Date date = new Date(cal.getTimeInMillis()); //시작날짜 기준 월요일 -> 일요일
                if(tempDate.equals(date)){
                    weeklyDailyMeals.add(beforeWeeklyDailyMeals.get(key));
                    if(key< beforeWeeklyDailyMeals.size()-1) key++;
                }
                else{
                    //없는 날짜의 정보의 경우 임시 인스턴스르 만들어서 보내줌
                    //만약 실제 데이터가 필요하다면 추가도 할수 있음
                    //Dailymeal tempDaily = new Dailymeal(id, date ,0, 0, 0, 0, 0, 0); -11은 임시 인스턴스
                    weeklyDailyMeals.add(new Dailymeal(id, date ,0, 0, 0, 0, 0, -11));
                }
                cal.add(Calendar.DATE,1);//하루씩 더해감
            }
        }
        //return beforeWeeklyDailyMeals;
        return weeklyDailyMeals;
    }

    @ResponseBody //칼로리만 보내는
    @GetMapping("/checkWeeklyMealCalories.do")
    public List<Integer> checkWeeklyMealCalories(String id, Date startDate, Date endDate) throws ParseException {

        //시작이 월요일 부터임(받는 데이터가)
        List<Dailymeal> beforeWeeklyDailyMeals = dailymealRepository.findByWeeklymealId(id, startDate,endDate);
        //일주일 데이터가 있을수도 있고 없을수도 없는 데이터(처리전 저장부)
        List<Integer> weeklyDailyMealsCalories = new ArrayList<Integer>();
        //처리후 저장부
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        int key=0; //hash size 만큼 돌기위해서
        /*날짜 포맷 변경코드//*///SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");if(sdf.format(tempDate).equals(sdf.format(date))){

        for(int i=0;i<7;i++){ //일주일
            Date tempDate =  beforeWeeklyDailyMeals.get(key).getDatekey(); //db에 있는 날짜

            Date date = new Date(cal.getTimeInMillis()); //시작날짜 기준 월요일 -> 일요일
            if(tempDate.equals(date)){
                weeklyDailyMealsCalories.add(beforeWeeklyDailyMeals.get(key).getCalorie());
                if(key< beforeWeeklyDailyMeals.size()-1) key++;
            }
            else{
                //없는 날짜의 정보의 경우 임시 인스턴스르 만들어서 보내줌
                //만약 실제 데이터가 필요하다면 추가도 할수 있음
                weeklyDailyMealsCalories.add(0);
            }
            cal.add(Calendar.DATE,1);//하루씩 더해감
        }
        //return beforeWeeklyDailyMeals;
        return weeklyDailyMealsCalories;
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