package com.api.mykoipond.seeder;


import com.api.mykoipond.dao.*;
import com.api.mykoipond.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Date;
import java.util.*;

@Component
public class Initializer {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PondRepository pondRepository;
    @Autowired
    BreedRepository breedRepository;
    @Autowired
    SubBreedRepository subBreedRepository;
    @Autowired
    ParasiteRepository parasiteRepository;
    @Autowired
    KoiRepository koiRepository;
    @Autowired
    KoiParasiteRepository koiParasiteRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    RoleRepository roleRepository;


    private List<PondEntity> pondEntities;
    private List<UserEntity> userEntities;
    private List<BreedEntity> breedEntities;
    private List<SubBreedEntity> subBreedEntities;
    private List<ParasiteEntity> parasiteEntities;
    private List<KoiEntity> koiEntities;
    private List<KoiParasiteEntity> koiParasiteEntities;
    private List<SizeEntity> sizeEntities;
    private List<RoleEntity> roleEntities;

    @EventListener
    public void run(ContextRefreshedEvent event) {
        pondTableSeeder();
        roleTableSeeder();
        userTableSeeder();
        breedTableSeeder();
        koiTableSeeder();
        parasiteTableSeeder();
        sizeTableSeeder();
    }

    public void pondTableSeeder() {
        pondEntities = Arrays.asList(
                PondEntity.builder()
                        .name("Pond Garden")
                        .description("blablabla")
                        .build(),
                PondEntity.builder()
                        .name("Pond Quarantaine")
                        .description("blablabla")
                        .build()
        );
        if (pondRepository.findAll().size() == 0) {
            pondRepository.saveAll(pondEntities);
        }
    }
    public void roleTableSeeder(){
        roleEntities = Arrays.asList(
                RoleEntity.builder()
                        .name("Admin")
                        .build(),
                RoleEntity.builder()
                        .name("Member")
                        .build()
        );
        if(roleRepository.findAll().size() == 0){
            roleRepository.saveAll(roleEntities);
        }
    }
    public void userTableSeeder() {
        HashSet<PondEntity> ponds = new HashSet<>(pondEntities);
        System.out.println(ponds.toString());
        userEntities = Arrays.asList(
                UserEntity.builder()
                        .firstName("Rik")
                        .lastName("Peeters")
                        .email("rik@test.nl")
                        .password("password")
                        .username("Rik")
                        .roles(new HashSet<>(roleEntities))
                        .ponds(ponds)
                        .build()
        );
        if (userRepository.findAll().size() == 0) {
            userRepository.saveAll(userEntities);
        }
    }


    public void breedTableSeeder() {
        breedEntities = Arrays.asList(
                //region
                //1
                BreedEntity.builder()
                        .name("Kohaku")
                        .description("Witte koi met rode patronen")
                        .build(),
                //2
                BreedEntity.builder()
                        .name("Taisho Sanshoku (Sanke)")
                        .description("Witte koi met rode en zwarte patronen — Het zwart mag niet onder de laterale lijn (zijlijn) komen — het zwart op de borstvinnen ligt erop als een soort streepjes, en deze streepjes hoeven niet te beginnen bij het aanhechtingspunt van de borstvin maar het mag wel — Het zwart mag niet op het hoofd komen.")
                        .build(),
                //3
                BreedEntity.builder()
                        .name("Showa Sanshoku (Showa)")
                        .description("Zwarte koi met witte en rode patronen — Het zwart komt tot onder de laterale lijn (zijlijn). — Het zwart ligt op de borstvinnen als een soort vlek, en deze vlek begint bij het aanhechtingspunt van de borstvin. — Het zwart loop door tot op de kop.")
                        .build(),
                //4
                BreedEntity.builder()
                        .name("Asagi")
                        .description("Koi met licht blauwe schijn aan de bovenkant en rode schijn aan de onderkant")
                        .build(),
                //5
                BreedEntity.builder()
                        .name("Shusui")
                        .description("Koi met een lijn met blauwe schubben op de rug, netjes gelijk verdeeld. En de staartvin, borstvinnen en kieuwdeksel hebben vaak een rood of oranje kleur. Kruising van een Asagi en een Doitsu.")
                        .build(),
                //6
                BreedEntity.builder()
                        .name("Bekko")
                        .description("Witte, rode of gele koi met zwarte vlekken")
                        .build(),
                //7
                BreedEntity.builder()
                        .name("Utsurimono")
                        .description("Zwarte koi met rode, witte of gele patronen")
                        .build(),
                //8
                BreedEntity.builder()
                        .name("Goshiki")
                        .description("een (gedeeltelijk) zwarte koi met rode, witten, bruine en blauwe accenten")
                        .build(),
                //9
                BreedEntity.builder()
                        .name("Goromo")
                        .description("een witte koi met donkerrode tot paarse vlekken (buddo goromo) of witte koi met rood met zwart omlijnde schubben vlekken(ai goromo)")
                        .build(),
                //10
                BreedEntity.builder()
                        .name("Ogon")
                        .description("een koi met een eentonig kleurpatroon, al dan niet metaalachtig. Bekende kleuren zijn rood, oranje, platina, geel en zilver")
                        .build(),
                //11
                BreedEntity.builder()
                        .name("Kawarimono")
                        .description("de niet-geklasseerde soorten/patronen")
                        .build(),
                //12
                BreedEntity.builder()
                        .name("Hikari")
                        .description("Dit zijn meerkleurige koi met een metaalglans over de schubben. Deze variëteit omvat ook kruisingen van OGON met eenandere variëteit met een witte basiskleur.")
                        .build(),
                //13
                BreedEntity.builder()
                        .name("Doitsu")
                        .description("Bijna elke koi-variëteit bestaat in schubloze vorm.")
                        .build()
                //endregion
        );
        subBreedEntities = Arrays.asList(
                // region
                // Kohaku(0)
                SubBreedEntity.builder()
                        .name("Doitsu Kohaku'")
                        .description("deels geschubd of schubbenloze kohaku")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Inazuma Kohaku")
                        .description("(zigzag-kohaku) Roodtekening in bliksemschichtvorm")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ippon-Hi")
                        .description("kohaku met een rode tekening van de kop tot aan de staart")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kuchibeni Kohaku")
                        .description("(lipvlek-kohaku) rode markering op de lippen.")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Menkaburi of Zukinkaburi Kohaku")
                        .description("Een Kohaku met een geheel rood hoofd")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Nidan Kohaku")
                        .description("(tweevlek-kohaku) twee rode vlekken")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sandan Kohaku")
                        .description("(drievlek-kohaku) drie grote rode vlekken")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Yondan Kohaku")
                        .description("(viervlek-kohaku) viervlektekening")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Maruten Kohaku")
                        .description("een kohaku met een rode vlek op het hoofd en andere rode patronen elders op het lichaam")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Tancho Kohaku")
                        .description("met één rode vlek op de kop, verder is de koi spierwit")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Dainichi Maruten Kohaku")
                        .description("koi met losstaand rood patroon op kop")
                        .breed(breedEntities.get(0))
                        .build(),


                //Sanke(1)
                SubBreedEntity.builder()
                        .name("Nidan Sanke")
                        .description("een sanke met twee rode vlekken")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sandan Sanke")
                        .description("een sanke met drie rode vlekken")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Yondan Sanke")
                        .description("een sanke met vier rode vlekken")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Aka Sanke")
                        .description("een bijna volledig rode sank")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kuchibeni Sanke")
                        .description("een sanke met rode lippen")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Maruten Sanke")
                        .description("een sanke met een rode vlek op het hoofd en andere rode patronen elders op het lichaam")
                        .breed(breedEntities.get(1))
                        .build(),
                SubBreedEntity.builder()
                        .name("Tancho Sanke")
                        .description("een shiro bekko met een tancho-vlek")
                        .breed(breedEntities.get(1))
                        .build(),


                // Showa(2)
                SubBreedEntity.builder()
                        .name("Kindai Showa")
                        .description("een moderne showa met weinig zwart.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi Showa")
                        .description("een showa met zeer veel rood.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Maruten Showa")
                        .description("een showa met een rode vlek op het hoofd en andere rode patronen elders op het lichaam.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Maruten Showa")
                        .description("een showa met een rode vlek op het hoofd en andere rode patronen elders op het lichaam.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Tancho Showa")
                        .description("een shiro utsuri met een tancho-vlek.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Showa")
                        .description("een showa waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden deze koi ingedeeld in de showa-klasse omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
                        .breed(breedEntities.get(2))
                        .build(),
                SubBreedEntity.builder()
                        .name("Boke Showa")
                        .description("een showa met vervaagd of grijzachtig zwart.")
                        .breed(breedEntities.get(2))
                        .build(),


                // Utsurimono(7)
                SubBreedEntity.builder()
                        .name("Shiro Utsuri")
                        .description("een zwarte koi met witte patronen (niet te verwarren met de shiro bekko, een witte vis met zwarte patronen)")
                        .breed(breedEntities.get(7))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi Utsuri")
                        .description("een zwarte koi met rode patronen")
                        .breed(breedEntities.get(7))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Shiro Utsuri")
                        .description("een shiro utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden deze koi ingedeeld in de utsurimono-klasse, omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
                        .breed(breedEntities.get(7))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Ki Utsuri")
                        .description("een ki utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
                        .breed(breedEntities.get(7))
                        .build(),

                // Bekko(5)
                SubBreedEntity.builder()
                        .name("Shiro Bekko")
                        .description("een witte koi met zwarte patronen. Een goed exemplaar is zeer zeldzaam.")
                        .breed(breedEntities.get(5))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi Bekko")
                        .description("een rode koi met rode patronen. Een goed exemplaar is zeer zeldzaam.")
                        .breed(breedEntities.get(5))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ki Bekko")
                        .description("een gele koi met zwarte patronen. Een goed exemplaar is eveneens zeer zeldzaam.")
                        .breed(breedEntities.get(5))
                        .build(),

                // Asagi(3)
                SubBreedEntity.builder()
                        .name("Asagi")
                        .description("een witte koi met op de rug een blauw netpatroon en met meestal op de flanken onder de zijlijn een rode tekening. Dit rood komt ook op de wangen en he aanzet van de vinnen voor.")
                        .breed(breedEntities.get(3))
                        .build(),
                SubBreedEntity.builder()
                        .name("Asagi Magoi'")
                        .description("de oervorm bijna alle koi.")
                        .breed(breedEntities.get(3))
                        .build(),
                SubBreedEntity.builder()
                        .name("Konjo Asagi'")
                        .description("een zeer donkere asagi. Deze vorm wordt vaak niet gewaardeerd en wordt beschouwd als kweekafval.")
                        .breed(breedEntities.get(3))
                        .build(),
                SubBreedEntity.builder()
                        .name("Narumi Asagi'")
                        .description("een lichtblauwe asagi met een door fukurin veroorzaakt wit netpatroon.")
                        .breed(breedEntities.get(3))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi Asagi")
                        .description("een asagi waarbij het rood over de zijlijn uitkomt.")
                        .breed(breedEntities.get(3))
                        .build(),
                SubBreedEntity.builder()
                        .name("Mizu of Akebi Asagi")
                        .description("Een zeer lichte asagi.")
                        .breed(breedEntities.get(3))
                        .build(),


                // Shusui (4)
                SubBreedEntity.builder()
                        .name("Shusui'")
                        .description("een doitsu asagi. Hij is wit, heeft een rij blauwe schubben op de rug en ook rode vlekken op de flanken.")
                        .breed(breedEntities.get(4))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi Shusui'")
                        .description("een shusui met geheel rode flanken.")
                        .breed(breedEntities.get(4))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ki Shusui")
                        .description("een shusui met geheel gele flanken.")
                        .breed(breedEntities.get(4))
                        .build(),

                // Goromo aka Koromo (0)
                SubBreedEntity.builder()
                        .name("Ai Goromo")
                        .description("een kohaku met zwarte boogjes op het einde van de rode schubben.")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Budo Goromo")
                        .description("een kohaku met een purperachtige kern in de rode schubben")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sumi Goromo")
                        .description("Geen beschrijving later toevoegen")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Goromo of Ai Showa")
                        .description("een ai goromo met diep zwarte showa-markeringen. Op het hoofd komen liefst de drie showa-kleuren voor.")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Goromo Sanke")
                        .description("een ai goromo met diep zwarte sanke-markeringen.")
                        .breed(breedEntities.get(0))
                        .build(),
                SubBreedEntity.builder()
                        .name("Budo Sanke")
                        .description("een budo goromo met diep zwarte markeringen.")
                        .breed(breedEntities.get(0))
                        .build(),


                // Goshiki
                SubBreedEntity.builder()
                        .name("Goshiki")
                        .description("een vijfkleurige koi (rood, wit, zwart, lichtblauw, donkerblauw).")
                        .breed(breedEntities.get(7))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kindai Goshiki")
                        .description("een goshiki met een lichte basiskleur.")
                        .breed(breedEntities.get(7))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kuro Goshikii")
                        .description("een goshiki met een donkere basiskleur.")
                        .breed(breedEntities.get(7))
                        .build(),

                // Kawarimono
                SubBreedEntity.builder()
                        .name("Aka Matsuba")
                        .description("een rode koi met een dennenappelpatroon (matsuba) waarbij de rode schub in het midden zwart bevat. Op het hoofd mogen er geen zwarte vlekjes voorkomen. In tegenstelling tot de 2 andere matsubagoi, is de Aka Matsuba niet zo zeldzaam.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Aka Muji")
                        .description("een geheel roodoranje koi.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Aka-Hajiro")
                        .description("een rode of oranje koi met witte randen aan de vinnen.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Akame Kigoi")
                        .description("lijkt op een albino kigoi, maar is geen albino. Deze zeldzame variëteit is simpelweg een kigoi met rode ogen.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Batsukawa-Bake")
                        .description("een voornamelijk zwarte koi met witte tinten, vooral bij de schubbe")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Benikoki")
                        .description("een kruising van een doitsu goshiki en een kujaku")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Beni Kumonryu")
                        .description("een kumonryu met rode patronen")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Benigoi")
                        .description("een geheel rode niet-metaalachtige diep karmijnrode koi. Het grote verschil met een aka muiji is dat een benigoi een veel diepere kleur heeft. Een goede benigoi komt echter zelden voor.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Bunka Sanke")
                        .description("een sanke met onderhuids blauw dat later verdwijnt. Deze vis heeft ook glanzende borstvinnen.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Bunka Shusui")
                        .description("blauwe sanke met glimmende borstvinnen. Dit type zie je alleen als ze jong zijn. Naarmate ze ouder worden, verliezen ze de glans.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Chagoi")
                        .description("cha betekent bruin. Een eenkleurige niet metaalachtige koi met lichtbruine of saffraanachtige kleur. Een jonge koi kan bruinachtig geel zijn. Dit type is het makkelijkst tam te maken en ze groeien zeer snel. Soms lijkt hij een soort netwerkpatroon over zich te hebben.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Enyu")
                        .description("ongetwijfeld de zeldzaamste koi ter wereld. Deze doitsugoi is purperkleurig met rode vlekken. Men bekomt deze door het kruisen van een shusui en een al zeer zeldzame midorigoi. Deze oudercombinatie wordt al zeldzaam gebruikt in Japan en dan komt men er dan nog maar 1 tegen na een aantal jaar.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Gin Kabuto")
                        .description("een bruin of zwarte koi met zilveren schubranden en een zilveren schijn over het hoofd.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Goshiki Shusui'")
                        .description("een niet metaalkleurige blauwe doitsu-goshiki.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hageshiro'")
                        .description("het broertje van de hagiro, maar met meer wit. Behalve op de randen van de vinnen, komt wit ook voor op het hoofd.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hi-Botan")
                        .description("een shiro utsuri waarvan de sumi-vlekken kleiner zijn en verspreid liggen over heel het lichaam. Beginners verwarren hem vaak met een bekko, maar de hi-botan heeft veel meer zwarte vlekjes.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Hi Utsuri''")
                        .description("een hi utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse, omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Shiro Utsuri'")
                        .description("een shiro utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kage Showa")
                        .description("een showa waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kanoko Kohaku")
                        .description("een kohaku met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kanoko Sanke")
                        .description("een sanke met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kanoko Showa")
                        .description("een showa met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.'")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Karashigoi")
                        .description("door het kruisen van een chagoi en een kigoi bekomt met soms een mosterdkleurige variëteit. Karashi betekent mosterd in het Japans. Vele beginners denken dat deze koi een chagoi is, maar hij is geler van kleur.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Karasugoi")
                        .description("letterlijk kraaivis. Een meestal zwarte/donkere soort met soms een witte of oranje buik. Aangezien deze soort zeer donker is, vinden hobbyisten ze meestal vrij lelijk.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ki Matsuba")
                        .description("een gele koi met een dennenappelpatroon waarvan de gele schubben een zwarte kern hebben. Deze variëteit is zeer zeldzaam.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kigoi")
                        .description("een volledig gele niet-metaalkleurige koi. Wordt vaak verward met een yamabuki ogon, maar deze is metaalkleurig.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kin Kabuto")
                        .description("in het Nederlands betekent dit gouden helm. Het is een zwarte koi met een gouden hoofd en gouden schubranden.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kosui")
                        .description("een kumonryu, maar in plaats van zwarte, rode patronen.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kumonryu")
                        .description("een doitsu zwarte koi met witte vlekken. Naargelang het seizoen en de watertemperatuur verandert het patroon soms.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Magoi")
                        .description("een zwarte Japanse oerkarper die in Japan en China in de rijstvelden zwom en als consumptievis werd gebruikt. Na een tijdje kwamen er door middel van inteelt kleurmutaties voor, de basis van de huidige koi. Deze koi kan zeer groot worden en is zeer tam, maar door zijn donkere kleur en omdat hij in het wild is te vinden, komen deze niet vaak voor in sier- en koivijvers.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Midorigoi")
                        .description("midori betekent groen. Dit is een van de meest zeldzame koi. Hij heeft een soort mythologische reputatie. Een doitsu midori-goi werd in 1963 gekweekt door een kruising tussen een vrouwelijke shusui en een mannelijke yamabuki ogon. Deze groengele koi met zwarte of zilverkleurige schubben wordt vaak zwart door zijn shusui afkomst, of juist heel lichtgroen.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ochiba Shigure")
                        .description("een kruising van een chagoi en een soragoi. Dit geeft een blauwgrijze koi met bruine patronen. Zoals zijn beide ouders groeit ook deze zeer snel en is zeer tam.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sanke Shusu")
                        .description("bij deze doitsu-sanke ligt onder de tekening het blauwzwart van de traditionele shusui.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Shiro Matsuba")
                        .description("een witte koi met een dennenappelpatroon (matsuba) waarvan de witte schubben een zwarte kern hebben, wat een zeer speciaal effect geeft. Helaas is deze koi uiterst zeldzaam.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Shiro-Muji")
                        .description("een volledig witte niet-metaalachtige koi. Een platinium ogon zonder glans om het simpel te houden. Maar aangezien deze koi niets speciaals heeft, is deze waardeloos. Hij is meestal kweekafval van een kohaku-kweek.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Showa Shusui")
                        .description("blauwe shusui basiskleur met daarover een krachtige sumi en showa tekening.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Soragoi")
                        .description("een blauwgrijze versie van de chagoi. Ook deze is zeer tam en groeit snel.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sumi-Nagashi")
                        .description("een zwarte koi waarvan de zwarte schubben een wit randje hebben. Hierdoor ontstaat een netpatroon zoals bij de asagi. In Japan ook wel asagi sumi-nagashi genoemd.")
                        .breed(breedEntities.get(10))
                        .build(),
                SubBreedEntity.builder()
                        .name("Yotsushiro")
                        .description("nog een andere vis van de familie van de hajiro, deze heeft op 5 plaatsen wit: de rugvin, de staartvin, de beide borstvinnen en het hoofd.")
                        .breed(breedEntities.get(10))
                        .build(),


                // Hikari Moyomono(11)
                SubBreedEntity.builder()
                        .name("Kujaku")
                        .description("een shiro matsuba (witte koi met een netpatroon) met oranjerode vlekken.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Beni Kujaku")
                        .description("een oranjerode kujaku met rode markeringen over het hele lichaam.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Doitsu Kujaku")
                        .description("een niet-geschubde kujaku. Het is precies een doitsu sakura ogon met een rij blauwgrijze op de rug.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Heisei Nishiki")
                        .description("een doitsu yamatonishiki. Een doitsu metallic witte koi wet rode en zwarte patronen.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Doitsu Hariwake")
                        .description("een schubloze hariwake.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Sakura Ogon, Platinium Kohaku of Kin Fuji")
                        .description("een metallic kohaku")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Koshi Nishiki")
                        .description("een kruising tussen een yamabuki ogon en een gin showa.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Yamatonishiki")
                        .description("een metallic sanke.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Ginsui")
                        .description("een zilvermetaalglanzende shusui.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kinshui")
                        .description("een goudmetaalglanzende shusui.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Shochikubai")
                        .description("Shochikubai")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Doitsu Shochikubai")
                        .description("een doitsu metallic ai goromo.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Gin Bekko")
                        .description("een metallic shiro bekko")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Gin Aka Bekko")
                        .description("een metallic aka bekko.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kikokuryu")
                        .description("een metallic kumonryu.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Beni Kikokuryu'")
                        .description("een metallic beni kumonryu.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Hariwake Matsuba'")
                        .description("Hariwake Matsuba")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Tora Ogon")
                        .description("een metallic ki bekko.")
                        .breed(breedEntities.get(11))
                        .build(),


                // Hikari Utsurimono
                SubBreedEntity.builder()
                        .name("Gin Shiro")
                        .description("een metallic shiro utsuri.")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kin Hi Utsuri")
                        .description("een metallic hi utsuri..")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kin Ki Utsuri")
                        .description("een metallic kin ki utsuri")
                        .breed(breedEntities.get(11))
                        .build(),
                SubBreedEntity.builder()
                        .name("Kin Showa")
                        .description("een metallic showa")
                        .breed(breedEntities.get(11))
                        .build()
                //endregion
        );
        if (breedRepository.findAll().size() == 0) {

            breedRepository.saveAll(breedEntities);

            subBreedRepository.saveAll(subBreedEntities);
        }
    }

    public void koiTableSeeder() {
        koiEntities = Arrays.asList(
                KoiEntity.builder()
                        .name("Jantje")
                        .description("Beste koi in de vijver")
                        .birth(new Date(Calendar.getInstance().getTime().getTime()))
                        .sex("male")
                        .pond(pondEntities.get(0))
                        .subBreed(subBreedEntities.get(3))
                        .build(),
                KoiEntity.builder()
                        .name("Clau")
                        .description("Mooie vis")
                        .birth(new Date(Calendar.getInstance().getTime().getTime()))
                        .sex("female")
                        .pond(pondEntities.get(0))
                        .subBreed(subBreedEntities.get(2))
                        .build(),
                KoiEntity.builder()
                        .name("Geertje")
                        .description("Beste koi in de vijver")
                        .birth(new Date(Calendar.getInstance().getTime().getTime()))
                        .sex("male")
                        .pond(pondEntities.get(1))
                        .subBreed(subBreedEntities.get(0))
                        .build(),
                KoiEntity.builder()
                        .name("Sam")
                        .description("Mooie vis")
                        .birth(new Date(Calendar.getInstance().getTime().getTime()))
                        .sex("female")
                        .pond(pondEntities.get(1))
                        .subBreed(subBreedEntities.get(4))
                        .build()
        );
        if (koiRepository.findAll().size() == 0) {
            koiRepository.saveAll(koiEntities);
        }
    }

    public void parasiteTableSeeder() {
        parasiteEntities = Arrays.asList(
                //region
                ParasiteEntity.builder()
                        .name("ARGULUS OF KARPERLUIS")
                        .description("De Argulus is een van de meest voor-komende parasieten op vijvervissen, de Argulus kan ongeveer 10 mm groot worden en heeft een ronde vorm met twee schotelvormige zuignappen. Tussen deze zuignappen zitten de naaldvormige delen van de mond, waarmee de Argulus zich door de huid van vis dringt. De klieren van de Argulus produceren een vergif wat door de holle naalden stroomt, met een zaagachtige bewegingen van de mond breekt de Argulus het aangetaste weefsel open. De schade die ze bij de vis aanbrengen bestaat uit het onttrekken van bloed vloeistof en weefselsappen, Op de plaats waar een Argulus heeft gezeten vormt zich een opvallende rode plek op de vis. De huid van de vis raakt erg geïrriteerd door de aanwezigheid van de Argulussen, de vis zal gaan schuren en uit het water gaan springen. Op de verwondingen kunnen ook weer infectie van bacterïen of schimmels komen. Als de vis niet snel behandeld wordt is hij meestal reddeloos verloren.\n" +
                                "\n" +
                                "De levenscyclus van de Argulus is als volgt:\n" +
                                "De volwassen Argulussen zitten met hun zuignappen op de vissen, de volwassen vrouwtjes verlaten de vis om hun eitjes te leggen in gelatineachtige capsules, waarnaar de jonge Argulussen diversen groeistadia doorlopen waaruit ze steeds weer vervellen. Bij watertemperaturen van boven de 16 graden stoppen de vrouwtjes met het leggen van de eitjes.")
                        .build(),
                ParasiteEntity.builder()
                        .name("CHILODONELLA")
                        .description("Chilodonella is een ovale eencellige parasiet maar is geen echte zwakte parasiet, hij komt en ontwikkelt zich ook op gezonde vissen. Op bijna alle zoetwatervissen komt hij voor, vooral jonge vissen zijn gevoelig en lijden dan ook meer als oudere vissen. Een tijdige behandeling is dus zeker noodzakelijk. Aangetaste vissen vertonen onder meer ademhaling moeilijkheden door de aangetaste kieuwen, de vissen hangen meestal bij mekaar aan de oppervlakte naar lucht te happen. Soms liggen ze ook op de bodem, verder symptomen zijn schurende bewegingen een doffe huid en het knijpen van de vinnen. De parasiet komt in eerste instantie voor op in de kieuwen en in een later stadium ook op de huid en dan vooral tussen de kop en de rugvin. De aan getaste vissen produceren dan ook meer slijm wat de kenmerkende huidtroebeling geeft. De melkblauwe huidtroebeling geeft ronde tot ovale plekken in hele erge gevallen wordt de huid dik en laat zelfs los, ook de kieuwen zijn dan al volledig vernield alleen de kieuwbogen zullen dan nog overblijven. Daarom is een tijdige constatering en behandeling ook noodzakelijk. Bij geen tijdige behandeling zal de vis ook doodgaan.")
                        .build(),
                ParasiteEntity.builder()
                        .name("COSTIA")
                        .description("Costia is van de drie meest voorkomende eencellige die voor huidtroebeling verantwoordelijk zijn de moeilijkst bestrijdbare, Een Trichodina infectie is het makkelijkste gevolgd door de Chilodonella infectie en dan dus de Costia. Costia is een flagelaat en Chilodonella en Trichodina zijn ciliaten. Onder de microscoop is Costia bij een vergroting vanaf 400 keer aan zijn tuimelende zwembeweging en zijn boonvormig uiterlijk te herkennen. Omdat de parasiet de plaats aantast waar de schubben in de huid vastzitten, is het moeilijk voor de koi om er van af te komen. De eerste kenmerken van een aan-tasting zijn overmatige productie van huidslijm, het lijkt net of er over de huid een laagje dichte grijze mist hangt waardoor de kleuren ver-vagen. De vinnen worden ook weer geknepen maar de ademhaling is niet versneld dit is pas aan het eind van het ziekte verloop. Het vaststellen van de precieze aantasting kan alleen plaats vinden door middel van een huidafstrijkje van een levende vis en microscopisch onderzoek van dit huidafstrijkje. Costia kan niet leven zonder gastheer en is dus een echte parasiet een aantasting komt vaak voor door een te dicht bevolkte vijver en op reeds verzwakte vissen. Een gezonde vissen word zelden besmet of heeft er geen last van, vaak heeft de vis al verzwakking opgelopen tijdens te ruwe behandeling van vangst en transport. De vissen zijn dus lusteloos ademen moeilijker schuren zich op de bodem of hangen aan de oppervlakte en de bewegingen zijn traag. Bij een massale infectie is de huid verwoest en heeft een bloed doorlopen uiterlijk")
                        .build(),
                ParasiteEntity.builder()
                        .name("DACTYLOGYRUS OF KIEUWWORM")
                        .description("Dactylogyrus of kieuwworm behoren tot de monogene trematoden, en ze variëren van grote van 0,5 mm tot 2 mm. Ze hebben 4 ogen waarmee ze donker en licht kunnen onderscheiden en ze planten zich voort via de eieren die ze leggen. En de haakstructuur die ze hebben dient als vast hechting orgaan. Dit zijn meteen de grote verschillen tussen kieuw en huidwormen, voor de rest lijken de kieuw en de huidwormen heel veel op mekaar. De 4 ogen vallen meteen op bij een onderzoek met een microscoop bij een vergroting van 50x tot 100x, gelukkig hebben de larven ook al 4 ogen en kunnen we ze dus goed onderscheiden met de larven van de huidworm. De kieuwworm legt zijn eieren in de kieuwen van zijn gastheer hoe meer zuurstof er in het water zit hoe meer eieren hij legt na het leggen van de eieren sterft de parasiet. Besmette vissen zijn te herkennen aan schichtig zwemmen en slechte groei ze zijn donkerder gekleurd en ze schuren met een van de kieuwzijde, in een later stadium krijgen ze ademnood. Behandelingen moeten meestal 2 maal herhaald worden omdat de eieren meestal niet door de middelen gedood worden.")
                        .build(),
                ParasiteEntity.builder()
                        .name("ERGASILUS OF KIEUWKREEFTJES")
                        .description("Ergasilus of Kieuwkreeftjes, de infectie van deze parasiet komt meestal voor op vissen die leven op de bodem of in de lagere waterlagen. Dit komt omdat ze zwaarder als water zijn en dus vooral op de bodem voor komen, de larven leven vrij in het water. Bij de vrouwtjes ontwikkelt het eerste benen paar zich tot krachtige haken waarmee ze zich vast hechten in de kieuwen van de vissen. Volwassen kieuwkreeftjes zijn tot 2mm groot en zoeken vaak grotere vissen op omdat ze bij kleine vissen te kleine kieuwen hebben om zich goed vast te kunnen grijpen. Aangetaste vissen vermageren en de kieuwen worden bloedarm en bleek, en de vissen worden lusteloos. Op de foto zijn de aangetaste kieuwen van een Koi te zien door Ergasilus. De volwassen vrouwtjes worden ook wel \"kieuwwormen\" genoemd vanwege de wormachtige witte eierzakken. De kieuwkreeftjes kunnen zelf overbrengers zijn van parasitaire wormen, ze dienen vaak als tussen gastheer. Gelukkig komt de parasiet niet veel voor bij Koi, wel is het raadzaam om nieuwe vissen te controleren.")
                        .build(),
                ParasiteEntity.builder()
                        .name("GYRODACTYLUS OF HUIDWORM")
                        .description("Gyrodactylus of huidworm behoort tot de monogene trematoden, hun grote varieert van 0,2mm tot 1,2mm. Ze hebben geen ogen het hoofdeinde is gesplitst op elk uiteinde bevinden zich kanaaltjes die een kleverige substantie uitscheiden, het achterdeel heeft twee grote haken en de rand van het achterdeel heeft 16 kleine haken. Ze hechten zich vast met deze haken in het huidweefsel van de vis en veroorzaken zo grote en ernstige schade en irritatie, het bindweefsel wordt vernield en de huid laat los. Er komt dan vaak ook nog een bacteriële infectie bij. De huidwormen zijn levendbarend, na de zelfbevruchting ontwikkelen de wormen zich in de buikholte van het ouderdier. Vaak zijn er meerdere generatie in de buikholte te vinden, soms wel vier generaties dit is te zien onder de microscoop bij een ver-grooting van 200x tot 400x. Vissen met een aantasting zijn te herkennen aan een vermagering van de vissen door minder eetlust en door schichtig en schurend zwemmen en donkerkleuring en aan een blauwgrijs slijmerig huidbeslag. Bij een huid afstrijkje van is onder de microscoop bij een vergroting van tussen de 50x en de 100x al een duidelijk beeld te zien van de snel bewegende huidwormen.")
                        .build(),
                ParasiteEntity.builder()
                        .name("LERNAEA OF ANKERKREEFTJES (ANKERWORM)")
                        .description("Bij een eerste waarneming wordt deze parasiet nogal eens aangezien voor een worm vandaar dat hij nogal eens ankerworm wordt genoemd, maar dit klopt dus niet deze parasiet behoort dus tot de kreefachtigen. De mannetjes wijken van vorm helemaal af van de vrouwtjes, de mannetjes komen ook niet als parasiet op de vis voor. De mannetjes sterven ook na de voortplanting die meestal rond mei plaats vind, de vrouwtjes dringen zich dan nog dieper in het weefsel van de vis en verplaatsen zich dan niet meer. Het achterlijf steekt dan nog tussen de schubben uit, aan het uiteinde zijn de twee lange eierzakjes te zien.Aan het andere einde(wat dus meestal niet te zien is vanwege het feit dat dit in vis vastzit) vinden we een aparte kop met het hecht orgaan in de vorm van een scheepsanker waarmee zij zich diep in de huid dringt. De wijfjes zijn slank en zijn van 6mm tot 23 mm groot. De wijfjes blijven leven tot eind mei in leven en sterven dan af, en vallen gewoon van de vis af met medeneming van stukken huid en spierweefsel ze veroorzaken daarbij grote gaten. Deze gaten genezen zeer moeilijk, meestal komt er dan een bacteriële of een schimmelinfectie bij wat de dood van de vis als gevolg heeft. De larven lijken op jonge cyclops en zwemmen tot ze een geschikte vis tegenkomen. De parasiet beweegt zich vaak rond zwemmend van gastheer tot gastheer, waarbij hij zich voedt met kleine deeltjes slijmhuid en bloed uit de kieuwen, de schade hiervan is zeer beperkt pas als de vrouwtjes zich vast nestelen in de vis rond de voortplanting wordt er grote schade aangericht. Aan getaste vissen zwemmen schichtig en onrustig rond, schubben kunnen plaatselijk uitsteken, de vis gaat schuren om de parasiet kwijt te raken, waarbij dus ook weer verwondingen kunnen ontstaan. In het laatste stadium vertragen de bewegingen en hangen en tuimelen de vissen. De parasiet is met het blote oog te herkennen, jonge parasieten zijn moeilijker te herkennen zeker op bepaalde kleuren zijn ze moeilijk te zien. Besmette vissen zijn het best afzonderling te behandelen als het maar om een paar vissen gaat.")
                        .build(),
                ParasiteEntity.builder()
                        .name("TETRAHYMENA SP")
                        .description("Tetrahymena sp. is een eencellig wimperdiertje, en behoort tot de ciliaten en heeft een ovale vorm. Die in jonge vorm erg op witte stip lijkt, maar met een goede microscoop bij een voldoende grote vergroting is het verschil goed te zien. De parasiet zwemt vrij rond, het liefst in zeer vervuild organisch water. Ze vermenigvuldigen zich zeer snel op verzwakte vissen door celdeling, en de parasiet brengt ernstige schade toe aan geïnfecteerd weefsel van de huid en de kieuwen. Het is meestal niet vast te stellen wat het schuren van de vissen veroorzaakt omdat vaak meerdere andere infecties aanwezig zijn. In een verder gevorderd stadium zal de huid van de vis verkleuren. Onder de microscoop is Tetrahymena goed te herkennen bij een vergroting van 100x tot 200x, ze komen altijd in grote aantallen voor. Het is belangrijk om goed te kijken naar andere parasieten omdat Tetrahymena meestal voorkomt op vissen die al aangetast zijn door andere parasieten. Als je Tetrahymena op je vissen aantreft duidt dit meestal op een slechte waterkwaliteit met hoge nitriet en nitraatwaarde en op slechte verzorging en dus op verzwakte en stervende vissen.")
                        .build(),
                ParasiteEntity.builder()
                        .name("TRICHODINA")
                        .description("Trichodina is een eencellige schotell-vormige parasiet die op de huid en kieuwen voorkomt. Hij gebruikt de vis alleen maar als vervoermiddel, tijdens het vervoer hecht hij zich vast aan de vis en beschadigt zo de slijmhuid. Deze beschadigde slijmhuid kan weer aanleiding zijn tot snelle vermeerdering van deze parasiet. De parasiet kan tot in de vis en zelfs tot in de darmen doordringen, hij schaaft met zijn trilhaartjes het celmateriaal weg, het celmateriaal gebruikt hij weer als voedsel. Trichodina doet het goed in vervuild water, en is dan ook vaak met andere parasieten te vinden.")
                        .build(),
                ParasiteEntity.builder()
                        .name("WITTE STIP")
                        .description("Witte stip is de meest bekende en voorkomende infectie bij vissen door trilhaardiertjes (ciliaten) en is met het blote oog te herkennen aan de witte stippen op de vissen. Het ziektebeeld treedt meestal op na aankoop van nieuwe vissen, de witte stippen zijn een soort kleine blaasjes en bevinden zich onder de slijmlaag en zijn irriterend en veroorzaken schade die vaak weer een bacteriële infectie tot gevolg hebben. De parasiet boort zich als hij nog jong is door de slijmhuid heen, het volwassen stadium van witte stip zit dus niet op de vis maar onder de slijmhuid en is zo goed beschermd. De parasiet bestaat uit allemaal trilhaardjes en is dan ook zeer bewegelijk hij maakt hele gangen tussen de opper en de lederhuid, als hij volwassen is breekt hij door de opper huid heen en valt op de bodem. De parasiet heeft zich omhuld met een geleiachtige massa waar uit tussen de 250 tot 2000 cellen worden gevormd, de vermeerdering gaat dan zeer snel binnen 12 tot 20 uur verlaten de cellen het zwermstadium en gaan op zoek naar een gastheer dit moet binnen de 33 tot 60 uur gebeuren, dit is ook de enigste mogelijkheid om ze te bestrijden. We bestrijden ze dan gedurende 5 dagen en na 14 dagen herhalen we de kuur. Onder de microscoop is al vanaf 40 x de parasiet goed te zien, alleen de volwassen parasieten hebben de typische U-vormige kern.")
                        .build(),
                ParasiteEntity.builder()
                        .name("ZWEMBLAAS")
                        .description("De zwemblaas is een orgaan in de vis met een dun omhulsel en is met een gas gevuld, dit zorgt voor de stijgkracht van de vis. Indien de vis dus problemen heeft met zijn zwemblaas kan hij de stijgkracht niet meer regelen en zichzelf niet meer stabiliseren. Het is een vrij complex systeem van gas uitwisseling tussen zwemblaas en bloedsomloop het werkt zeer langzaam en daar door kunnen plotselinge temperatuursschommelingen al voor een ontsteking zorgen van de zwemblaas hij kan echter ook van bacteriële aard zijn. We kennen twee verschijnselen:\n" +
                                "\n" +
                                "1. Overdruk dus te veel gas in de zwemblaas dan hebben we vissen die boven blijven zogenaamde kopstaanders.\n" +
                                "\n" +
                                "2. Onderdruk dus te weinig gas in de zwemblaas dan liggen de vissen op de bodem en kunnen enkele door zeer actief zwemmen nog bewegen.\n" +
                                "\n" +
                                "De zwemblaas is bij een ontsteking rood gekleurd in plaats van zilverachtig, meestal is ook het oogreflex een stuk minder of zelfs helemaal weg.\n" +
                                "\n" +
                                "De behandeling is niet eenvoudig in geval van de plotselinge temperatuursverschillen kan het euvel zich herstellen door de vis in een quarantaine bak met een lage waterstand te doen. (De lage waterstand zorgt ervoor dat de vis z'n krachten kan sparen in plaats van veel moeite te doen om naar boven te komen. Weinig water stelt natuurlijk wel hogere eisen aan het filteren en verversen en van water.) En dan geleidelijk de temperatuur van het water te verhogen met enkele graden per dag (2 á 3 graden per etmaal.)tot een temperatuur van ca 28 graden Celsius De vis hierin een week laten zwemmen. Daarna de temperatuur weer geleidelijk afbouwen van het water. Soms kan een zoutbad ook herstel te weeg brengen of een inspuiting van een antibiotica maar dit is zelden afdoende en lijdt ook zelden tot volledige genezing. Indien er na een week geen verbetering optreedt is het aan te raden de Koi uit zijn lijden te verlossen. Een operatie is ook een mogelijkheid maar is vrij kostbaar.")
                        .build()
                //endregion
        );
        koiParasiteEntities = Arrays.asList(
                KoiParasiteEntity.builder()
                        .comment("Ziet er zeer slecht uit")
                        .date(new Date(Calendar.getInstance().getTime().getTime()))
                        .koi(koiEntities.get(0))
                        .parasite(parasiteEntities.get(0))
                        .build()
        );
        if (parasiteRepository.findAll().size() == 0) {
            parasiteRepository.saveAll(parasiteEntities);
            koiParasiteRepository.saveAll(koiParasiteEntities);
        }
    }

    public void sizeTableSeeder() {
        sizeEntities = Arrays.asList(
                SizeEntity.builder()
                        .comment("Best wel lang goede vordering")
                        .date(new Date(Calendar.getInstance().getTime().getTime()))
                        .koi(koiEntities.get(0))
                        .size(75)
                        .build()
        );
        if (sizeRepository.findAll().size() == 0) {
            sizeRepository.saveAll(sizeEntities);
        }
    }
}


//    @Bean
//    public ApplicationRunner init(
//            BreedRepository breedRepository,
//            SubBreedRepository subBreedRepository,
//            PondRepository pondRepository,
//            UserRepository userRepository
//    ) {
//        if (breedRepository.findAll().size() == 0) {
//            breedRepository.deleteAllInBatch();
//            subBreedRepository.deleteAllInBatch();
//
//            return args -> {
//                List<BreedEntity> breedEntities = Arrays.asList(
//                        //region Description
//                        //1
//                        BreedEntity.builder()
//                                .name("Kohaku")
//                                .description("Witte koi met rode patronen")
//                                .build(),
//                        //2
//                        BreedEntity.builder()
//                                .name("Taisho Sanshoku (Sanke)")
//                                .description("Witte koi met rode en zwarte patronen — Het zwart mag niet onder de laterale lijn (zijlijn) komen — het zwart op de borstvinnen ligt erop als een soort streepjes, en deze streepjes hoeven niet te beginnen bij het aanhechtingspunt van de borstvin maar het mag wel — Het zwart mag niet op het hoofd komen.")
//                                .build(),
//                        //3
//                        BreedEntity.builder()
//                                .name("Showa Sanshoku (Showa)")
//                                .description("Zwarte koi met witte en rode patronen — Het zwart komt tot onder de laterale lijn (zijlijn). — Het zwart ligt op de borstvinnen als een soort vlek, en deze vlek begint bij het aanhechtingspunt van de borstvin. — Het zwart loop door tot op de kop.")
//                                .build(),
//                        //4
//                        BreedEntity.builder()
//                                .name("Asagi")
//                                .description("Koi met licht blauwe schijn aan de bovenkant en rode schijn aan de onderkant")
//                                .build(),
//                        //5
//                        BreedEntity.builder()
//                                .name("Shusui")
//                                .description("Koi met een lijn met blauwe schubben op de rug, netjes gelijk verdeeld. En de staartvin, borstvinnen en kieuwdeksel hebben vaak een rood of oranje kleur. Kruising van een Asagi en een Doitsu.")
//                                .build(),
//                        //6
//                        BreedEntity.builder()
//                                .name("Bekko")
//                                .description("Witte, rode of gele koi met zwarte vlekken")
//                                .build(),
//                        //7
//                        BreedEntity.builder()
//                                .name("Utsurimono")
//                                .description("Zwarte koi met rode, witte of gele patronen")
//                                .build(),
//                        //8
//                        BreedEntity.builder()
//                                .name("Goshiki")
//                                .description("een (gedeeltelijk) zwarte koi met rode, witten, bruine en blauwe accenten")
//                                .build(),
//                        //9
//                        BreedEntity.builder()
//                                .name("Goromo")
//                                .description("een witte koi met donkerrode tot paarse vlekken (buddo goromo) of witte koi met rood met zwart omlijnde schubben vlekken(ai goromo)")
//                                .build(),
//                        //10
//                        BreedEntity.builder()
//                                .name("Ogon")
//                                .description("een koi met een eentonig kleurpatroon, al dan niet metaalachtig. Bekende kleuren zijn rood, oranje, platina, geel en zilver")
//                                .build(),
//                        //11
//                        BreedEntity.builder()
//                                .name("Kawarimono")
//                                .description("de niet-geklasseerde soorten/patronen")
//                                .build(),
//                        //12
//                        BreedEntity.builder()
//                                .name("Hikari")
//                                .description("Dit zijn meerkleurige koi met een metaalglans over de schubben. Deze variëteit omvat ook kruisingen van OGON met eenandere variëteit met een witte basiskleur.")
//                                .build(),
//                        //13
//                        BreedEntity.builder()
//                                .name("Doitsu")
//                                .description("Bijna elke koi-variëteit bestaat in schubloze vorm.")
//                                .build()
//                        //endregion
//                );
//                breedRepository.saveAll(breedEntities);
//
//                List<SubBreedEntity> subBreedEntities = Arrays.asList(
//                        //region Description
//                        // Kohaku(0)
//                        SubBreedEntity.builder()
//                                .name("Doitsu Kohaku'")
//                                .description("deels geschubd of schubbenloze kohaku")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Inazuma Kohaku")
//                                .description("(zigzag-kohaku) Roodtekening in bliksemschichtvorm")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ippon-Hi")
//                                .description("kohaku met een rode tekening van de kop tot aan de staart")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kuchibeni Kohaku")
//                                .description("(lipvlek-kohaku) rode markering op de lippen.")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Menkaburi of Zukinkaburi Kohaku")
//                                .description("Een Kohaku met een geheel rood hoofd")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Nidan Kohaku")
//                                .description("(tweevlek-kohaku) twee rode vlekken")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sandan Kohaku")
//                                .description("(drievlek-kohaku) drie grote rode vlekken")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Yondan Kohaku")
//                                .description("(viervlek-kohaku) viervlektekening")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Maruten Kohaku")
//                                .description("een kohaku met een rode vlek op het hoofd en andere rode patronen elders op het lichaam")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Tancho Kohaku")
//                                .description("met één rode vlek op de kop, verder is de koi spierwit")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Dainichi Maruten Kohaku")
//                                .description("koi met losstaand rood patroon op kop")
//                                .breed(breedEntities.get(0))
//                                .build(),
//
//
//                        //Sanke(1)
//                        SubBreedEntity.builder()
//                                .name("Nidan Sanke")
//                                .description("een sanke met twee rode vlekken")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sandan Sanke")
//                                .description("een sanke met drie rode vlekken")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Yondan Sanke")
//                                .description("een sanke met vier rode vlekken")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Aka Sanke")
//                                .description("een bijna volledig rode sank")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kuchibeni Sanke")
//                                .description("een sanke met rode lippen")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Maruten Sanke")
//                                .description("een sanke met een rode vlek op het hoofd en andere rode patronen elders op het lichaam")
//                                .breed(breedEntities.get(1))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Tancho Sanke")
//                                .description("een shiro bekko met een tancho-vlek")
//                                .breed(breedEntities.get(1))
//                                .build(),
//
//
//                        // Showa(2)
//                        SubBreedEntity.builder()
//                                .name("Kindai Showa")
//                                .description("een moderne showa met weinig zwart.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi Showa")
//                                .description("een showa met zeer veel rood.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Maruten Showa")
//                                .description("een showa met een rode vlek op het hoofd en andere rode patronen elders op het lichaam.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Maruten Showa")
//                                .description("een showa met een rode vlek op het hoofd en andere rode patronen elders op het lichaam.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//                    SubBreedEntity.builder()
//                            .name("Tancho Showa")
//                            .description("een shiro utsuri met een tancho-vlek.")
//                            .breed(breedEntities.get(2))
//                            .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Showa")
//                                .description("een showa waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden deze koi ingedeeld in de showa-klasse omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Boke Showa")
//                                .description("een showa met vervaagd of grijzachtig zwart.")
//                                .breed(breedEntities.get(2))
//                                .build(),
//
//
//                        // Utsurimono(7)
//                        SubBreedEntity.builder()
//                                .name("Shiro Utsuri")
//                                .description("een zwarte koi met witte patronen (niet te verwarren met de shiro bekko, een witte vis met zwarte patronen)")
//                                .breed(breedEntities.get(7))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi Utsuri")
//                                .description("een zwarte koi met rode patronen")
//                                .breed(breedEntities.get(7))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Shiro Utsuri")
//                                .description("een shiro utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden deze koi ingedeeld in de utsurimono-klasse, omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
//                                .breed(breedEntities.get(7))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Ki Utsuri")
//                                .description("een ki utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
//                                .breed(breedEntities.get(7))
//                                .build(),
//
//                        // Bekko(5)
//                        SubBreedEntity.builder()
//                                .name("Shiro Bekko")
//                                .description("een witte koi met zwarte patronen. Een goed exemplaar is zeer zeldzaam.")
//                                .breed(breedEntities.get(5))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi Bekko")
//                                .description("een rode koi met rode patronen. Een goed exemplaar is zeer zeldzaam.")
//                                .breed(breedEntities.get(5))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ki Bekko")
//                                .description("een gele koi met zwarte patronen. Een goed exemplaar is eveneens zeer zeldzaam.")
//                                .breed(breedEntities.get(5))
//                                .build(),
//
//                        // Asagi(3)
//                        SubBreedEntity.builder()
//                                .name("Asagi")
//                                .description("een witte koi met op de rug een blauw netpatroon en met meestal op de flanken onder de zijlijn een rode tekening. Dit rood komt ook op de wangen en he aanzet van de vinnen voor.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Asagi Magoi'")
//                                .description("de oervorm bijna alle koi.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Konjo Asagi'")
//                                .description("een zeer donkere asagi. Deze vorm wordt vaak niet gewaardeerd en wordt beschouwd als kweekafval.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Narumi Asagi'")
//                                .description("een lichtblauwe asagi met een door fukurin veroorzaakt wit netpatroon.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi Asagi")
//                                .description("een asagi waarbij het rood over de zijlijn uitkomt.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Mizu of Akebi Asagi")
//                                .description("Een zeer lichte asagi.")
//                                .breed(breedEntities.get(3))
//                                .build(),
//
//
//                        // Shusui (4)
//                        SubBreedEntity.builder()
//                                .name("Shusui'")
//                                .description("een doitsu asagi. Hij is wit, heeft een rij blauwe schubben op de rug en ook rode vlekken op de flanken.")
//                                .breed(breedEntities.get(4))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi Shusui'")
//                                .description("een shusui met geheel rode flanken.")
//                                .breed(breedEntities.get(4))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ki Shusui")
//                                .description("een shusui met geheel gele flanken.")
//                                .breed(breedEntities.get(4))
//                                .build(),
//
//                        // Goromo aka Koromo (0)
//                        SubBreedEntity.builder()
//                                .name("Ai Goromo")
//                                .description("een kohaku met zwarte boogjes op het einde van de rode schubben.")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Budo Goromo")
//                                .description("een kohaku met een purperachtige kern in de rode schubben")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sumi Goromo")
//                                .description("Geen beschrijving later toevoegen")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Goromo of Ai Showa")
//                                .description("een ai goromo met diep zwarte showa-markeringen. Op het hoofd komen liefst de drie showa-kleuren voor.")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Goromo Sanke")
//                                .description("een ai goromo met diep zwarte sanke-markeringen.")
//                                .breed(breedEntities.get(0))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Budo Sanke")
//                                .description("een budo goromo met diep zwarte markeringen.")
//                                .breed(breedEntities.get(0))
//                                .build(),
//
//
//                        // Goshiki
//                        SubBreedEntity.builder()
//                                .name("Goshiki")
//                                .description("een vijfkleurige koi (rood, wit, zwart, lichtblauw, donkerblauw).")
//                                .breed(breedEntities.get(7))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kindai Goshiki")
//                                .description("een goshiki met een lichte basiskleur.")
//                                .breed(breedEntities.get(7))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kuro Goshikii")
//                                .description("een goshiki met een donkere basiskleur.")
//                                .breed(breedEntities.get(7))
//                                .build(),
//
//                        // Kawarimono
//                        SubBreedEntity.builder()
//                                .name("Aka Matsuba")
//                                .description("een rode koi met een dennenappelpatroon (matsuba) waarbij de rode schub in het midden zwart bevat. Op het hoofd mogen er geen zwarte vlekjes voorkomen. In tegenstelling tot de 2 andere matsubagoi, is de Aka Matsuba niet zo zeldzaam.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Aka Muji")
//                                .description("een geheel roodoranje koi.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Aka-Hajiro")
//                                .description("een rode of oranje koi met witte randen aan de vinnen.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Akame Kigoi")
//                                .description("lijkt op een albino kigoi, maar is geen albino. Deze zeldzame variëteit is simpelweg een kigoi met rode ogen.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Batsukawa-Bake")
//                                .description("een voornamelijk zwarte koi met witte tinten, vooral bij de schubbe")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Benikoki")
//                                .description("een kruising van een doitsu goshiki en een kujaku")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Beni Kumonryu")
//                                .description("een kumonryu met rode patronen")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Benigoi")
//                                .description("een geheel rode niet-metaalachtige diep karmijnrode koi. Het grote verschil met een aka muiji is dat een benigoi een veel diepere kleur heeft. Een goede benigoi komt echter zelden voor.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Bunka Sanke")
//                                .description("een sanke met onderhuids blauw dat later verdwijnt. Deze vis heeft ook glanzende borstvinnen.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Bunka Shusui")
//                                .description("blauwe sanke met glimmende borstvinnen. Dit type zie je alleen als ze jong zijn. Naarmate ze ouder worden, verliezen ze de glans.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Chagoi")
//                                .description("cha betekent bruin. Een eenkleurige niet metaalachtige koi met lichtbruine of saffraanachtige kleur. Een jonge koi kan bruinachtig geel zijn. Dit type is het makkelijkst tam te maken en ze groeien zeer snel. Soms lijkt hij een soort netwerkpatroon over zich te hebben.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Enyu")
//                                .description("ongetwijfeld de zeldzaamste koi ter wereld. Deze doitsugoi is purperkleurig met rode vlekken. Men bekomt deze door het kruisen van een shusui en een al zeer zeldzame midorigoi. Deze oudercombinatie wordt al zeldzaam gebruikt in Japan en dan komt men er dan nog maar 1 tegen na een aantal jaar.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Gin Kabuto")
//                                .description("een bruin of zwarte koi met zilveren schubranden en een zilveren schijn over het hoofd.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Goshiki Shusui'")
//                                .description("een niet metaalkleurige blauwe doitsu-goshiki.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hageshiro'")
//                                .description("het broertje van de hagiro, maar met meer wit. Behalve op de randen van de vinnen, komt wit ook voor op het hoofd.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hi-Botan")
//                                .description("een shiro utsuri waarvan de sumi-vlekken kleiner zijn en verspreid liggen over heel het lichaam. Beginners verwarren hem vaak met een bekko, maar de hi-botan heeft veel meer zwarte vlekjes.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Hi Utsuri''")
//                                .description("een hi utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse, omdat men bij jongere vissen moeilijk kan onderscheiden of het zwart is dat nog moet doorbreken of dat het kage is.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Shiro Utsuri'")
//                                .description("een shiro utsuri waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kage Showa")
//                                .description("een showa waarvan de zwarte patronen beschaduwd (kage) zijn. Tegenwoordig worden worden deze koi ingedeeld in de utsurimono-klasse.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kanoko Kohaku")
//                                .description("een kohaku met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kanoko Sanke")
//                                .description("een sanke met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kanoko Showa")
//                                .description("een showa met in plaats van volle rode patronen allemaal gespikkelde rode vlekjes.'")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Karashigoi")
//                                .description("door het kruisen van een chagoi en een kigoi bekomt met soms een mosterdkleurige variëteit. Karashi betekent mosterd in het Japans. Vele beginners denken dat deze koi een chagoi is, maar hij is geler van kleur.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Karasugoi")
//                                .description("letterlijk kraaivis. Een meestal zwarte/donkere soort met soms een witte of oranje buik. Aangezien deze soort zeer donker is, vinden hobbyisten ze meestal vrij lelijk.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ki Matsuba")
//                                .description("een gele koi met een dennenappelpatroon waarvan de gele schubben een zwarte kern hebben. Deze variëteit is zeer zeldzaam.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kigoi")
//                                .description("een volledig gele niet-metaalkleurige koi. Wordt vaak verward met een yamabuki ogon, maar deze is metaalkleurig.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kin Kabuto")
//                                .description("in het Nederlands betekent dit gouden helm. Het is een zwarte koi met een gouden hoofd en gouden schubranden.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kosui")
//                                .description("een kumonryu, maar in plaats van zwarte, rode patronen.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kumonryu")
//                                .description("een doitsu zwarte koi met witte vlekken. Naargelang het seizoen en de watertemperatuur verandert het patroon soms.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Magoi")
//                                .description("een zwarte Japanse oerkarper die in Japan en China in de rijstvelden zwom en als consumptievis werd gebruikt. Na een tijdje kwamen er door middel van inteelt kleurmutaties voor, de basis van de huidige koi. Deze koi kan zeer groot worden en is zeer tam, maar door zijn donkere kleur en omdat hij in het wild is te vinden, komen deze niet vaak voor in sier- en koivijvers.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Midorigoi")
//                                .description("midori betekent groen. Dit is een van de meest zeldzame koi. Hij heeft een soort mythologische reputatie. Een doitsu midori-goi werd in 1963 gekweekt door een kruising tussen een vrouwelijke shusui en een mannelijke yamabuki ogon. Deze groengele koi met zwarte of zilverkleurige schubben wordt vaak zwart door zijn shusui afkomst, of juist heel lichtgroen.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ochiba Shigure")
//                                .description("een kruising van een chagoi en een soragoi. Dit geeft een blauwgrijze koi met bruine patronen. Zoals zijn beide ouders groeit ook deze zeer snel en is zeer tam.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sanke Shusu")
//                                .description("bij deze doitsu-sanke ligt onder de tekening het blauwzwart van de traditionele shusui.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Shiro Matsuba")
//                                .description("een witte koi met een dennenappelpatroon (matsuba) waarvan de witte schubben een zwarte kern hebben, wat een zeer speciaal effect geeft. Helaas is deze koi uiterst zeldzaam.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Shiro-Muji")
//                                .description("een volledig witte niet-metaalachtige koi. Een platinium ogon zonder glans om het simpel te houden. Maar aangezien deze koi niets speciaals heeft, is deze waardeloos. Hij is meestal kweekafval van een kohaku-kweek.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Showa Shusui")
//                                .description("blauwe shusui basiskleur met daarover een krachtige sumi en showa tekening.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Soragoi")
//                                .description("een blauwgrijze versie van de chagoi. Ook deze is zeer tam en groeit snel.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sumi-Nagashi")
//                                .description("een zwarte koi waarvan de zwarte schubben een wit randje hebben. Hierdoor ontstaat een netpatroon zoals bij de asagi. In Japan ook wel asagi sumi-nagashi genoemd.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Yotsushiro")
//                                .description("nog een andere vis van de familie van de hajiro, deze heeft op 5 plaatsen wit: de rugvin, de staartvin, de beide borstvinnen en het hoofd.")
//                                .breed(breedEntities.get(10))
//                                .build(),
//
//
//                        // Hikari Moyomono(11)
//                        SubBreedEntity.builder()
//                                .name("Kujaku")
//                                .description("een shiro matsuba (witte koi met een netpatroon) met oranjerode vlekken.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Beni Kujaku")
//                                .description("een oranjerode kujaku met rode markeringen over het hele lichaam.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Doitsu Kujaku")
//                                .description("een niet-geschubde kujaku. Het is precies een doitsu sakura ogon met een rij blauwgrijze op de rug.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Heisei Nishiki")
//                                .description("een doitsu yamatonishiki. Een doitsu metallic witte koi wet rode en zwarte patronen.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Doitsu Hariwake")
//                                .description("een schubloze hariwake.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Sakura Ogon, Platinium Kohaku of Kin Fuji")
//                                .description("een metallic kohaku")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Koshi Nishiki")
//                                .description("een kruising tussen een yamabuki ogon en een gin showa.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Yamatonishiki")
//                                .description("een metallic sanke.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Ginsui")
//                                .description("een zilvermetaalglanzende shusui.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kinshui")
//                                .description("een goudmetaalglanzende shusui.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Shochikubai")
//                                .description("Shochikubai")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Doitsu Shochikubai")
//                                .description("een doitsu metallic ai goromo.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Gin Bekko")
//                                .description("een metallic shiro bekko")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Gin Aka Bekko")
//                                .description("een metallic aka bekko.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kikokuryu")
//                                .description("een metallic kumonryu.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Beni Kikokuryu'")
//                                .description("een metallic beni kumonryu.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Hariwake Matsuba'")
//                                .description("Hariwake Matsuba")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Tora Ogon")
//                                .description("een metallic ki bekko.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//
//
//                        // Hikari Utsurimono
//                        SubBreedEntity.builder()
//                                .name("Gin Shiro")
//                                .description("een metallic shiro utsuri.")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kin Hi Utsuri")
//                                .description("een metallic hi utsuri..")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kin Ki Utsuri")
//                                .description("een metallic kin ki utsuri")
//                                .breed(breedEntities.get(11))
//                                .build(),
//                        SubBreedEntity.builder()
//                                .name("Kin Showa")
//                                .description("een metallic showa")
//                                .breed(breedEntities.get(11))
//                                .build()
//                        //endregion
//                );
//                subBreedRepository.saveAll(subBreedEntities);
//            };
//        }
//        return null;
//    }
//
//    @Bean
//    public ApplicationRunner initr(RoleRepository repository) {
//        if(repository.findAll().size() == 0){
//            return args -> repository.saveAll(Arrays.asList(
//                    //1
//                    RoleEntity.builder()
//                            .name("ADMIN")
//                            .build(),
//                    //2
//                    RoleEntity.builder()
//                            .name("USER")
//                            .build()
//            ));
//        }
//        return null;
//    }
//
//    @Autowired
//    private PasswordEncoder bCryptPasswordEncoder;
//
//    @Bean
//    public ApplicationRunner initu(UserRepository repository) {
//        if(repository.findAll().size() == 0){
//            return args -> repository.saveAll(Arrays.asList(
//                    //1
//                    UserEntity.builder()
//                            .firstName("Rik")
//                            .lastName("Peeters")
//                            .username("rik")
//                            .password(bCryptPasswordEncoder.encode("secret"))
//                            .active(true)
//                            .email("rik@rik.com")
//                            .build()
//            ));
//        }
//        return null;
//    }
//}
