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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KaavaController {

//    private Date sysdate;
    ArrayList<String> suunnittelualue = new ArrayList<>();
    ArrayList<String> kaavatyyppi = new ArrayList<>();
    boolean empty = true;
    Kaavatilasto kaavatilasto;
    String kaavakaavatunnus;
    String kaavakaavanimi;
    String kaavalisatieto;
    String kaavahankkeenkuvaus;
    String kaavakaavatyyppi;
    String kaavasuunnittelualue;

    @Autowired
    KoodistoRepository koodistoRepository;

    @Autowired
    KaavatilastoRepository kaavatilastoRepository;

    @RequestMapping("/")
    public String home(Model model) {

        luoAlasvetoValikot();

        if (empty == false) {
            kaavakaavatunnus = kaavatilasto.getKaavatunnus();
            kaavakaavanimi = kaavatilasto.getKaavanimi();
            kaavalisatieto = kaavatilasto.getLisatieto();
            kaavahankkeenkuvaus = kaavatilasto.getHankkeenkuvaus();
            kaavakaavatyyppi = kaavatilasto.getKaavatyyppi();
            kaavasuunnittelualue = Integer.toString(kaavatilasto.getSuunnittelualue());

        } else {
            kaavakaavatunnus = "";
            kaavakaavanimi = "";
            kaavalisatieto = "";
            kaavahankkeenkuvaus = "";
            kaavakaavatyyppi = "";
            kaavasuunnittelualue = "";
        }

        model.addAttribute("kaavakaavatunnus", kaavakaavatunnus);
        model.addAttribute("kaavakaavanimi", kaavakaavanimi);
        model.addAttribute("kaavalisatieto", kaavalisatieto);
        model.addAttribute("kaavahankkeenkuvaus", kaavahankkeenkuvaus);
        model.addAttribute("kaavakaavatyyppi", kaavakaavatyyppi);
        model.addAttribute("kaavasuunnittelualue", kaavasuunnittelualue);
        model.addAttribute("suunnittelualue", suunnittelualue);
        model.addAttribute("kaavatyyppi", kaavatyyppi);

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@RequestParam String haku) {
        empty = true;
        if (!haku.trim().isEmpty()) {
            this.kaavatilasto = kaavatilastoRepository.findByKaavatunnus(haku.trim());
            System.out.println("kaavatilasto on "+kaavatilasto);
            if(this.kaavatilasto != null){
               empty = false; 
            }
            
        }
        return "redirect:/";
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
    
    private void luoAlasvetoValikot() {

        suunnittelualue.clear();
        kaavatyyppi.clear();
        //suunnittelualue

        for (Koodisto koodistodata : koodistoRepository.findAll()) {
            System.out.println("k:" + koodistodata.getKuvaus() + koodistodata.getRyhmakoodi());
            if (koodistodata.getRyhmakoodi() == 1) {
                this.suunnittelualue.add(koodistodata.getKuvaus());
            } else {
                this.kaavatyyppi.add(koodistodata.getKuvaus());
            }
        }

//        for (Koodisto koodistodata : koodistoRepository.suunnitteluAlue()) {
//            System.out.println("k:" + koodistodata.getKuvaus() + koodistodata.getRyhmakoodi());
//            this.suunnittelualue.add(koodistodata.getKuvaus());
//        }
//
//        for (Koodisto koodistodata : koodistoRepository.kaavaTyyppi()) {
//            System.out.println("k:" + koodistodata.getKuvaus() + koodistodata.getRyhmakoodi());
//            this.kaavatyyppi.add(koodistodata.getKuvaus());
//        }
    }

}
