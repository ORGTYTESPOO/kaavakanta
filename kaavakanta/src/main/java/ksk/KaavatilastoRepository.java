package ksk;

/**
 *
 * @author saara
 */
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KaavatilastoRepository extends CrudRepository<Kaavatilasto, Long> {

    // haku kaavatunnuksella
    Kaavatilasto findByKaavatunnus(String kaavatunnus);

//    @Modifying
//    @Query("update Kaavatilasto u set u.suunnittelualue = ?1 where u.kaavatunnus = ?2")
//    int updateSuunnittelualue(String kaavatunnus, String suunnittelualue);
//    
//    @Modifying
//    @Query("update Kaavatilasto u set u.kaavatyyppi = ?1 where u.kaavatunnus = ?2")
//    int updateKaavatyyppi(String kaavatunnus, String kaavatyyppi);
//    
    
    

}
