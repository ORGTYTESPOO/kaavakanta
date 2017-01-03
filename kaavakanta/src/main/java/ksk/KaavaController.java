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

    ArrayList<String> suunnittelualue = new ArrayList();
    ArrayList<String> kaavatyyppi = new ArrayList();
    ArrayList<String> hakulista = new ArrayList();

    boolean empty = true;
    Kaavatilasto kaavatilasto;
    String kaavakaavatunnus;
    String kaavakaavanimi;
    String kaavalisatieto;
    String kaavahankkeenkuvaus;
    String kaavakaavatyyppi;
    String kaavasuunnittelualue;
    String muutatietoja;

    @Autowired
    KoodistoRepository koodistoRepository;

    @Autowired
    KaavatilastoRepository kaavatilastoRepository;

    @Autowired
    HistoriaRepository historiaRepository;

    @RequestMapping("/")
    public String home(Model model) {

        nollaaValikot();
        luoHakulista();
        

        if (this.empty == false) {
            kaavakaavatunnus = kaavatilasto.getKaavatunnus();
            kaavakaavanimi = kaavatilasto.getKaavanimi();
            kaavalisatieto = kaavatilasto.getLisatieto();
            kaavahankkeenkuvaus = kaavatilasto.getHankkeenkuvaus();
            kaavakaavatyyppi = kaavatilasto.getKaavatyyppi();
            kaavasuunnittelualue = kaavatilasto.getSuunnittelualue();
            muutatietoja = "Muuta kaavan tietoja";
            luoAlasvetoValikot();

        } else {
            kaavakaavatunnus = "";
            kaavakaavanimi = "";
            kaavalisatieto = "";
            kaavahankkeenkuvaus = "";
            kaavakaavatyyppi = "";
            kaavasuunnittelualue = "";
            muutatietoja = "";
        }

        model.addAttribute("muutatietoja", muutatietoja);
        model.addAttribute("kaavakaavatunnus", kaavakaavatunnus);
        model.addAttribute("kaavakaavanimi", kaavakaavanimi);
        model.addAttribute("kaavalisatieto", kaavalisatieto);
        model.addAttribute("kaavahankkeenkuvaus", kaavahankkeenkuvaus);
        model.addAttribute("kaavakaavatyyppi", kaavakaavatyyppi);
        model.addAttribute("kaavasuunnittelualue", kaavasuunnittelualue);
        model.addAttribute("suunnittelualue", suunnittelualue);
        model.addAttribute("kaavatyyppi", kaavatyyppi);
        model.addAttribute("historia", historiaRepository.findAllByOrderByIdDesc());
        model.addAttribute("hakulista", hakulista);

        return "index";
    }

    @RequestMapping(value = "/haku", method = RequestMethod.POST)
    public String hakukentta(@RequestParam String hae) {

        haku(hae);

        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String kaavatyyppi, @RequestParam String suunnittelualue) {

        if (kaavatilasto != null) {
            //hae vanha objekti kaavakaavatunnuksella
            Kaavatilasto vanha = kaavatilastoRepository.findByKaavatunnus(kaavakaavatunnus);

//luo historiaentiteetti vanhasta objektista ja sysdatesta        
            Date sysdate = new Date();
            System.out.println("sysdate:"+sysdate);
            int hId = (int) historiaRepository.count();
            Historia hvanha = new Historia(hId + 1, vanha.getKaavatunnus(), vanha.getKaavanimi(), vanha.getLisatieto(), vanha.getHankkeenkuvaus(), vanha.getKaavatyyppi(), vanha.getSuunnittelualue(), sysdate);

            historiaRepository.save(hvanha);
//luo uusi entiteetti vanhasta ja aseta sille uudet arvot        
            Kaavatilasto uusi = vanha;
            uusi.setKaavatyyppi(kaavatyyppi);
            uusi.setSuunnittelualue(suunnittelualue);

            kaavatilastoRepository.save(uusi);

            haku(this.kaavatilasto.getKaavatunnus());

            //save it to history
            //create new entity, copy old entity info
            //set new kaavatyyppi and suunnittelualue
            //save it to kaavatilasto
//        formdatarepository.save(new Formdata(sysdate, book));
//        if (!kaavatyyppi.trim().isEmpty()) {
//            kaavatilastoRepository.updateKaavatyyppi(kaavakaavatunnus, kaavatyyppi);
//        }
//        if (!suunnittelualue.trim().isEmpty()) {
//            kaavatilastoRepository.updateSuunnittelualue(kaavakaavatunnus, suunnittelualue);
//        }
        }

        return "redirect:/";
    }

    //, @RequestParam String kaavatyyppi, @RequestParam String suunnittelualue
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String save(@RequestParam String var1) {
//
////        if (!var1.trim().isEmpty()) {
////            sysdate = new Date();
////            kaavatilastorepository.save(new Kaavatilasto(sysdate, var1));
////        }
//        return "redirect:/";
//    }
    private boolean haku(String haku) {

        // jos kaavatietoja ei ole haettu 
        this.empty = true;

        // kaavatunnuksella tai nimellä
        if (!haku.trim().isEmpty()) {
            // split haku
            int length = haku.split(" ").length;

            String[] hakusanat = haku.split(" ");
            for (int i = 0; i < length; i++) {
                if (kaavatilastoRepository.findByKaavatunnus(hakusanat[i].trim()) != null) {
                    this.kaavatilasto = kaavatilastoRepository.findByKaavatunnus(hakusanat[i].trim());
                    this.empty = false;
                    return true;
                }
            }
        }

        // mentiin loppuun eikä löytynyt
        return false;
    }
    
    private void nollaaValikot(){
        this.hakulista.clear();
        this.suunnittelualue.clear();
        this.kaavatyyppi.clear();
    }

    private void luoAlasvetoValikot() {

        

        //suunnittelualue
//       
//                for(Koodisto ko : koodistoRepository.findAll()){
//                    System.out.println("ko:"+ko.getKuvaus());
//                }
        for (Koodisto koodistodata : koodistoRepository.findAll()) {

            if (koodistodata.getRyhmakoodi() == 1) {
                this.suunnittelualue.add(koodistodata.getKuvaus());
            } else {
                this.kaavatyyppi.add(koodistodata.getKuvaus());
            }
        }

    }

    private void luoHakulista() {
        
        String kaavatunnus;
        String kaavanimi;
        for (Kaavatilasto kaavatilastodata : kaavatilastoRepository.findAll()) {
            kaavatunnus = kaavatilastodata.getKaavatunnus();
            kaavanimi = kaavatilastodata.getKaavanimi();
            this.hakulista.add(kaavatunnus + " " + kaavanimi);
        }
    }

}
