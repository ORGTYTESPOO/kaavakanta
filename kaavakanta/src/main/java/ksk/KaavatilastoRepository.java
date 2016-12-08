/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksk;

/**
 *
 * @author saara
 */
import org.springframework.data.repository.CrudRepository;
 
public interface KaavatilastoRepository  extends CrudRepository<Kaavatilasto, Long> {
    
}
