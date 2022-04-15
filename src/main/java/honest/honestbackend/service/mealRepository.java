package honest.honestbackend.service;

import honest.honestbackend.domain.Meal;
import honest.honestbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface mealRepository extends JpaRepository<Meal,Long> {
    //public Meal findById(String userId, Date date);
}
