package ksk;

/**
 *
 * @author saara
 */


import DB.Tietokanta;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KaavaController {

//    private Date sysdate;
    private String driver = "org.postgresql.Driver";
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/test1";
    private String username = "saara";
    private String password = "postgres";
//    Tietokanta t = new Tietokanta("org.postgresql.Driver", "jdbc:postgresql://SV-H-T-TIHA-1.espoo.ad.city:5432/ksk", "", "");    
    Tietokanta t = new Tietokanta(driver,jdbcUrl,username,password);
    ArrayList<String> suunnittelualue = new ArrayList<>();
    ArrayList<String> kaavatyyppi = new ArrayList<>();
//    ArrayList<Historia> historia = new ArrayList<>();
    boolean empty = true;
    Kaavatilasto kaavatilasto;
    String kaavakaavatunnus;
    String kaavakaavanimi;
    String kaavalisatieto;
    String kaavahankkeenkuvaus;
    String kaavakaavatyyppi;
    String kaavasuunnittelualue;
    String muutatietoja;

////    Jos käytettäisiin JPA:ta, mutta connection pool forked -ympäristössä ongelma
//    @Autowired
//    KoodistoRepository koodistoRepositoryJPA;
//
//    @Autowired
//    KaavatilastoRepository kaavatilastoRepositoryJPA;
//
//    @Autowired
//    HistoriaRepository historiaRepositoryJPA;
    
    KoodistoRepository koodistoRepository = new KoodistoRepository();

    @RequestMapping("/")
    public String home(Model model) {

        luoAlasvetoValikot();

        if (this.empty == false) {
            kaavakaavatunnus = kaavatilasto.getKaavatunnus();
            kaavakaavanimi = kaavatilasto.getKaavanimi();
            kaavalisatieto = kaavatilasto.getLisatieto();
            kaavahankkeenkuvaus = kaavatilasto.getHankkeenkuvaus();
            kaavakaavatyyppi = kaavatilasto.getKaavatyyppi();
            kaavasuunnittelualue = kaavatilasto.getSuunnittelualue();
            muutatietoja = "Muuta kaavan tietoja";

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
//        model.addAttribute("historia", historiaRepository.findAll());

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String hakukentta(@RequestParam String hae) {

//        haku(hae);

        return "redirect:/";
    }

    @RequestMapping(value = "/haku", method = RequestMethod.POST)
    public String save(@RequestParam String kaavatyyppi, @RequestParam String suunnittelualue) {

        if (kaavatilasto != null) {
            //hae vanha objekti kaavakaavatunnuksella
//            Kaavatilasto vanha = kaavatilastoRepository.findByKaavatunnus(kaavakaavatunnus);

//luo historiaentiteetti vanhasta objektista ja sysdatesta        
            Date sysdate = new Date();
//            Historia hvanha = new Historia(vanha.getId(), vanha.getKaavatunnus(), vanha.getKaavanimi(), vanha.getLisatieto(), vanha.getHankkeenkuvaus(), vanha.getKaavatyyppi(), vanha.getSuunnittelualue(), sysdate);
//luo uusi entiteetti vanhasta ja aseta sille uudet arvot        
//            Kaavatilasto uusi = vanha;
//            uusi.setKaavatyyppi(kaavatyyppi);
//            uusi.setSuunnittelualue(suunnittelualue);

//            historiaRepository.insert(hvanha);

//            kaavatilastoRepository.save(uusi);

//            haku(this.kaavatilasto.getKaavatunnus());

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
    
    
    
    
//    private void haku(String haku) {
//
//        this.empty = true;
//        if (!haku.trim().isEmpty()) {
//            this.kaavatilasto = kaavatilastoRepository.findByKaavatunnus(haku.trim());
//            //tarkistetaan myös ilman 049 alkua
//            if (this.kaavatilasto == null) {
//                this.kaavatilasto = kaavatilastoRepository.findByKaavatunnus("049" + haku.trim());
//            }
//            if (this.kaavatilasto != null) {
//                this.empty = false;
//            }
//        }
//    }

    private void luoAlasvetoValikot() {

        suunnittelualue.clear();
        kaavatyyppi.clear();
//        historia.clear();
        //suunnittelualue

        ArrayList<Koodisto> testi = koodistoRepository.findAll(this.t);
                for(Koodisto ko : testi){
                    System.out.println("ko:"+ko.getKuvaus());
                }
                
        for (Koodisto koodistodata : koodistoRepository.findAll(this.t)) {
            System.out.println("k:" + koodistodata.getKuvaus() + koodistodata.getRyhmakoodi());
            if (koodistodata.getRyhmakoodi() == 1) {
                this.suunnittelualue.add(koodistodata.getKoodi() + ":" + koodistodata.getKuvaus());
            } else {
                this.kaavatyyppi.add(koodistodata.getKuvaus());
            }
        }
//        
//        for(Historia h : historiaRepository.findAll()){
//            this.historia.add(muutatietoja);
//        }

    }

}
