package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class dailymealService {
    @Autowired
    dailymealRepository dailymealRepository;

    public void saveDailyMeal(Dailymeal dailymeal){
        System.out.println("회원가입 요청 들어옴");
        dailymealRepository.save(dailymeal);
    }

    public void test(){
        System.out.println(dailymealRepository.findAll().toString());
    }

    //public void setId(Dailymeal dailymeal){
    //    int count = dailymealRepository.countAllBy();
    //}

}
