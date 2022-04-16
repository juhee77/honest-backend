package honest.honestbackend.service;

import honest.honestbackend.domain.Meal;
import honest.honestbackend.domain.MealId;
import honest.honestbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface mealRepository extends JpaRepository<Meal, MealId> { //제네릭 타입
    //public Meal findById(String userId, Date date);
}
