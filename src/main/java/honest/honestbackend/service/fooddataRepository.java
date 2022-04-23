package honest.honestbackend.service;

import honest.honestbackend.domain.FoodData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface fooddataRepository extends JpaRepository<FoodData,Long> {
    //public FoodData findById(String id);

//    @Nullable
//    List<FoodData> findByNameContaining(String name);
    @Query(value="SELECT f From FoodData f WHERE f.name LIKE %:name%")//CONCAT('%',:name,'%') //%:name%
    List<FoodData> selectByItem(@Param("name") String name);

//    @Query("SELECT f FROM FoodData f WHERE f.name LIKE %?1%")
//    List<FoodData> selectByItem(String name);

}
