package honest.honestbackend.service;

import honest.honestbackend.domain.Dailymeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

public interface dailymealRepository extends JpaRepository<Dailymeal,Long> {
    public Dailymeal findById(String userId, Date date);
    public int countAllBy();

    @Transactional
    @Modifying(clearAutomatically = true)
    //@Query("UPDATE Dailymeal SET id = count WHERE uId =? userId and dateKey = date")
    //public Dailymeal setId(int count,String uId, Date date);



}

