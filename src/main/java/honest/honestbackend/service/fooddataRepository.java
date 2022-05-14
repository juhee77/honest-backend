package honest.honestbackend.service;

import honest.honestbackend.domain.FoodData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface fooddataRepository extends JpaRepository<FoodData,Long> {
    FoodData findById(long id);

//    @Nullable
//    List<FoodData> findByNameContaining(String name);
    @Query(value="SELECT f From FoodData f WHERE f.name LIKE %:name%")//CONCAT('%',:name,'%') //%:name%
    List<FoodData> selectByItem(@Param("name") String name);

    //단백질 부족의 경우
    //@Query(value="SELECT * From fooddata WHERE protein <= :protein+100 and :protein-100 <= protein  order by rand() limit 3 ", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata WHERE protein<= :protein+100 and :protein-100 <= protein and flag=1 order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByLackProtein(@Param("protein")int protein);

    //지방 부족의 경우
    //@Query(value="SELECT * From FoodData  WHERE fat <= :fat order by fat desc , calorie desc LIMIT 0, 3", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata  WHERE fat <= :fat+50 and flag=1 order by rand() limit 3", nativeQuery=true)
    List<FoodData> selectByLackfat(@Param("fat")int fat);

    //탄수화물 부족의 경우
    //@Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate order by carbohydrate desc , calorie desc LIMIT 0, 3", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate+50 and flag=1 order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByLackCarbohydrate(@Param("carbohydrate")int carbohydrate);

    //건강식 출력
    //@Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate+50 and flag=1 order by rand() limit 3 ", nativeQuery=true)
    //List<FoodData> selectByHealthy();

    //건강식 출력
    //@Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate+50 and flag=1 order by rand() limit 3 ", nativeQuery=true)
    //List<FoodData> selectByHealthy();

//    @Query("SELECT f FROM FoodData f WHERE f.name LIKE %?1%")
//    List<FoodData> selectByItem(String name);

}
