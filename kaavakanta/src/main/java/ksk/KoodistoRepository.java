
package ksk;

/**
 * @author saara
 */
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KoodistoRepository extends CrudRepository<Koodisto, Long> {

    @Query("SELECT k FROM Koodisto k WHERE k.ryhmakoodi = 1")
    ArrayList<Koodisto> suunnitteluAlue();

    @Query("SELECT k FROM Koodisto k WHERE k.ryhmakoodi = 2")
    ArrayList<Koodisto> kaavaTyyppi();
    
    
}
