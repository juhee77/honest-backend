package honest.honestbackend.service;

import honest.honestbackend.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface mealRepository extends JpaRepository<Meal, MealId> { //제네릭 타입
    //public Meal findById(String userId, Date date);
    @Query("select u from Meal u where u.userid = ?1 and u.dailymealid = ?2")
    public List<Meal> findBymealId(String id, long dailymealid);//mealid는 제외

    @Query("select u from Meal u where u.userid = ?1 and u.savetime = ?2 and u.timeflag=?3")
    List<Meal> selectByItem(String userid, Date savetime, int timeflag);
    public int countAllBy();

    @Query("select u from Meal u where u.userid = ?1 and u.savetime = ?2")
    List<Meal> selectBysaveTime(String userid, Date savetime);

    @Query("select Max(u.timeflag) from Meal u where u.userid = ?1 and u.savetime = ?2")
    int maxTimeFlag(String userid, Date savetime);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Meal m where m.userid = ?1 and m.savetime = ?2 and m.timeflag=?3")
    void deleteByItem(String userid, Date savetime, int timeflag);
}
