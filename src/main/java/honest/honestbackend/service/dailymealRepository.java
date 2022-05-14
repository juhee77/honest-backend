package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import honest.honestbackend.domain.DailymealId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;


public interface dailymealRepository extends JpaRepository<Dailymeal, DailymealId> {

    @Query("select u from Dailymeal u where u.userid = ?1 and u.datekey = ?2")
    public Dailymeal findByDailymealId(String id, Date date);

    @Query("select u from Dailymeal u where u.userid = :id and u.datekey between :startDate and :endDate")
    public List<Dailymeal> findByWeeklymealId(@Param("id")String id,@Param("startDate") Date startDate,@Param("endDate")Date endDate);

    public int countAllBy();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Dailymeal d SET d.userid = ?1, " +
            "d.datekey=?2, " +
            "d.stepcount=?3, " +
            "d.calorie=?4, " +
            "d.protein=?5, " +
            "d.carbohydrate=?6, " +
            "d.fat=?7, " +
            "d.dailymealid=?8 " +
            "where d.userid = ?1 and d.datekey=?2")
    void updateById(String userid, Date datekey, int stepcount, int calorie, int protein, int carbohydrate, int fat, BigInteger dailymealid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Meal m where m.userid = ?1")
    void deleteById(String userid);

    //@Transactional
    //@Modifying(clearAutomatically = true)
    //@Query("UPDATE Dailymeal SET id = count WHERE uId =? userId and dateKey = date")
    //public Dailymeal setId(int count,String uId, Date date);

}

