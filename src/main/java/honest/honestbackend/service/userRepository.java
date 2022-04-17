package honest.honestbackend.service;

import honest.honestbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface userRepository extends JpaRepository<User,Long> {

    public User findById(String id);

    @Transactional
    @Modifying(clearAutomatically = true)
    /*@Query(value = "UPDATE User u SET u.id = :id, " +
            "u.nickname=:nickname, " +
            "u.sex=:sex, " +
            "u.age=:age, " +
            "u.weight=:weight, " +
            "u.height=:height, " +
            "u.activity_index=:activity_index, " +
            "u.target_calories=:target_calories, " +
            "u.profile=:profile " +
            "where u.id= :id")*/
    @Query(value = "UPDATE User u SET u.id = ?1, " +
            "u.nickname=?2, " +
            "u.sex=?3, " +
            "u.age=?4, " +
            "u.weight=?5, " +
            "u.height=?6, " +
            "u.activity_index=?7, " +
            "u.target_calories=?8, " +
            "u.profile=?9 " +
            "where u.id=?1")
        //void updateById(@Param("id") String id, @Param("nickname") String nickname, @Param("sex") char sex, @Param("age") Integer age, @Param("weight") Integer weight, @Param("height") Integer height, @Param("activity_index") Integer activity_index, @Param("target_calories") Integer target_calories, @Param("profile") String profile);
    void updateById(String id, String nickname, char sex, Integer age, Integer weight, Integer height, Integer activity_index, Integer target_calories,String profile);


/*참고 --쿼리사용
    @Query("SELECT a FROM USER a WHERE a.oid = ?1")
    public CustomerVO findByUid(int id);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE USER SET noshow = noshow + 1 WHERE oid = ?1")
    public int increaseNoShowCount(int uid);
    */
     
}
