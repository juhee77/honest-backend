package honest.honestbackend.domain;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data

public class DailymealId implements Serializable {
    private String userId;
    private Date dateKey;
}
