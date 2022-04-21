package honest.honestbackend.service;

import honest.honestbackend.domain.FoodData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface fooddataRepository extends JpaRepository<FoodData,Long> {
    public FoodData findById(String id);
}
