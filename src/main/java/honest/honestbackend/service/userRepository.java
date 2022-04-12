package honest.honestbackend.service;

import honest.honestbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {

    public User findById(String id);

/*참고 --쿼리사용
    @Query("SELECT a FROM USER a WHERE a.oid = ?1")
    public CustomerVO findByUid(int id);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE USER SET noshow = noshow + 1 WHERE oid = ?1")
    public int increaseNoShowCount(int uid);
    */
     
}
