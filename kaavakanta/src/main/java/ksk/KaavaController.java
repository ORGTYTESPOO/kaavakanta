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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KaavaController {

//    private Date sysdate;
    ArrayList<String> suunnittelualue = new ArrayList<>();
    ArrayList<String> kaavatyyppi = new ArrayList<>();
    
    @Autowired
    KoodistoRepository koodistoRepository;
    
    @RequestMapping("/")
    public String home(Model model) {
        
        suunnittelualue.clear();
        String testi = "hei maailma";
        //suunnittelualue

//        for (Koodisto koodistodata : koodistoRepository.findAll()) {
//            System.out.println("k:"+koodistodata.getKuvaus()+koodistodata.getRyhmakoodi());
//            this.suunnittelualue.add(koodistodata.getKuvaus());
//        }   
//      


        for (Koodisto koodistodata : koodistoRepository.suunnitteluAlue()) {
            System.out.println("k:"+koodistodata.getKuvaus()+koodistodata.getRyhmakoodi());
            this.suunnittelualue.add(koodistodata.getKuvaus());
        }   
        
        
        for (Koodisto koodistodata : koodistoRepository.kaavaTyyppi()) {
            System.out.println("k:"+koodistodata.getKuvaus()+koodistodata.getRyhmakoodi());
            this.kaavatyyppi.add(koodistodata.getKuvaus());
        }  
   
       

        
        model.addAttribute("suunnittelualue", suunnittelualue);
        
        model.addAttribute("kaavatyyppi", kaavatyyppi);

        return "index";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String save(@RequestParam String var1) {
//
////        if (!var1.trim().isEmpty()) {
////            sysdate = new Date();
////            kaavatilastorepository.save(new Kaavatilasto(sysdate, var1));
////        }
//        return "redirect:/";
//    }
}
