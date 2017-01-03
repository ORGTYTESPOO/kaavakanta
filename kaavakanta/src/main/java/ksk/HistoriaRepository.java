package ksk;


/**
 *
 * @author saara
 */

import java.util.List;
import org.springframework.data.repository.CrudRepository;
 
public interface HistoriaRepository  extends CrudRepository<Historia, Long> {
    public List<Historia> findAllByOrderByIdDesc();
    
}
