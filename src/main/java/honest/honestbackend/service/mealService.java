package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mealService {
    @Autowired
    mealRepository mealRepository;

    public void saveMeal(Meal Meal){
        System.out.println("회원가입 요청 들어옴");
        mealRepository.save(Meal);
    }

    public void mealTest(){
        System.out.println(mealRepository.findAll().toString());
    }
}
