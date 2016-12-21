
package ksk;

/**
 *
 * @author saara
 */
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
public interface KaavatilastoRepository  extends CrudRepository<Kaavatilasto, Long> {
    
    // haku kaavatunnuksella
    Kaavatilasto findByKaavatunnus(String kaavatunnus);
}
