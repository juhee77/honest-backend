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

    @Query(value="SELECT f From FoodData f WHERE f.name= ?1")
    FoodData selectByName(@Param("name") String name);

//    @Query("SELECT f FROM FoodData f WHERE f.name LIKE %?1%")
//    List<FoodData> selectByItem(String name);

    //단백질 부족의 경우
    //@Query(value="SELECT * From fooddata WHERE protein <= :protein+100 and :protein-100 <= protein  order by rand() limit 3 ", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata WHERE protein<= :protein+100 and :protein-100 <= protein and (flag=1 or flag=2) order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByLackProtein(@Param("protein")int protein);

    //지방 부족의 경우
    //@Query(value="SELECT * From FoodData  WHERE fat <= :fat order by fat desc , calorie desc LIMIT 0, 3", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata  WHERE fat <= :fat+50 and (flag=1 or flag=2) order by rand() limit 3", nativeQuery=true)
    List<FoodData> selectByLackfat(@Param("fat")int fat);

    //탄수화물 부족의 경우
    //@Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate order by carbohydrate desc , calorie desc LIMIT 0, 3", nativeQuery=true)
    @Nullable
    @Query(value="SELECT * From fooddata WHERE carbohydrate <= :carbohydrate+50 and (flag=1 or flag=2) order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByLackCarbohydrate(@Param("carbohydrate")int carbohydrate);

    //건강식 출력 칼로리 부족한 경우
    @Query(value="SELECT * From fooddata WHERE calorie <= :calorie+100 and :calorie-100 <= calorie and flag=2 order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByHealthyAscCalorie(@Param("calorie") int calorie);

    //건강식 출력 칼로리 초과 TODO: 수정 필요 매번 같은 음식 나옴
    @Query(value="SELECT * From fooddata WHERE flag=2 order by calorie LIMIT 0, 3 ", nativeQuery=true)
    List<FoodData> selectByHealthyDescCalorie();

    //그냥 건강식 중 랜덤 3가지 출력
    @Query(value="SELECT * From fooddata WHERE flag=2 order by rand() limit 3 ", nativeQuery=true)
    List<FoodData> selectByHealthyRand3();

    //그냥 건강식 중 랜덤 2가지 출력
    @Query(value="SELECT * From fooddata WHERE flag=2 order by rand() limit 2 ", nativeQuery=true)
    List<FoodData> selectByHealthyRand2();

    // 그냥 건강식 중 랜덤 1가지 출력
    @Query(value="SELECT * From fooddata WHERE flag=2 order by rand() limit 1 ", nativeQuery=true)
    List<FoodData> selectByHealthyRand1();




//    @Query("SELECT f FROM FoodData f WHERE f.name LIKE %?1%")
//    List<FoodData> selectByItem(String name);

}
