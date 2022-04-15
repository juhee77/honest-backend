package honest.honestbackend.domain;

import javax.persistence.Id;
import java.io.Serializable;

public class MealId implements Serializable {
    private String userId;
    private int dailymealId;
}
