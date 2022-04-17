package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.DailymealId;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

@Service
public class dailymealService {
    @Autowired
    dailymealRepository dailymealRepository;

    public void saveDailyMeal(Dailymeal dailymeal){
        System.out.println("dailymeal 업데이트 or 생성 ");
        dailymealRepository.save(dailymeal);
    }

    public Dailymeal checkDailyMeal(String id, Date datekey){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        //Date date = new Date(sdf.format(datekey)); //시간 때문에 형식을 바꿈 00시로 바꿔줘야 함..
        Dailymeal dailymeal = dailymealRepository.findByDailymealId(id, datekey);

        //System.out.println(dailymeal2.toString());
        if(dailymeal==null){
            System.out.println("중복없음!");
            Dailymeal Dailymeal = new Dailymeal(id, datekey, 0, 0, 0, 0, 0, dailymealRepository.countAllBy()+1);
            //dailymealRepository.save(Dailymeal); // 만약 없으면 새로 만들기 , make new dailymeal
            System.out.println(Dailymeal.toString());
            return Dailymeal;
        }
        else{
            System.out.println("중복있음!");
            System.out.println(dailymeal.toString());
            return dailymeal;

        }

    }

    public void test(){
        System.out.println(dailymealRepository.findAll().toString());
    }

    //public void setId(Dailymeal dailymeal){
    //    int count = dailymealRepository.countAllBy();
    //}

}
