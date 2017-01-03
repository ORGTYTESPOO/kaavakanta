package ksk;


/**
 *
 * @author saara
 */


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KaavatilastoRepository extends CrudRepository<Kaavatilasto, Long> {

    // haku kaavatunnuksella
    Kaavatilasto findByKaavatunnus(String kaavatunnus);
    
    public List<Kaavatilasto> findAllByOrderByIdDesc();

    public Kaavatilasto findByKaavatunnusContaining(String string);

    public List<Kaavatilasto> findByKaavanimiContaining(String string);

}
