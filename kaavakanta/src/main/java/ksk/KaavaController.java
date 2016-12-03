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
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KaavaController {
 
    private Date sysdate;
    
    @Autowired
    KoodistoRepository koodistorepository;
    @Autowired
    KaavatilastoRepository kaavatilastorepository;
    
    
    @RequestMapping("/")
    public String home(Model model) {
    return "index";    
    }
    
        @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@RequestParam String var1) {

//        if (!var1.trim().isEmpty()) {
//            sysdate = new Date();
//            kaavatilastorepository.save(new Kaavatilasto(sysdate, var1));
//        }
        return "redirect:/";
    }
    
    
}
