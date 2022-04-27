package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.Meal;
import honest.honestbackend.domain.MealId;
import honest.honestbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

public interface mealRepository extends JpaRepository<Meal, MealId> { //제네릭 타입
    //public Meal findById(String userId, Date date);
    @Query("select u from Meal u where u.userid = ?1 and u.dailymealid = ?2")
    public List<Meal> findBymealId(String id, long dailymealid);//mealid는 제외

    public int countAllBy();
}
