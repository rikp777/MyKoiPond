package com.api.mykoipond.seeder;


import com.api.mykoipond.dao.BreedRepository;
import com.api.mykoipond.dao.SubBreedRepository;
import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.SubBreedEntity;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
//public class Initializer {
//
//    @Bean
//    public ApplicationRunner init(BreedRepository breedRepository, SubBreedRepository subBreedRepository) {
//        breedRepository.deleteAllInBatch();
//        subBreedRepository.deleteAllInBatch();
//
//
//        BreedEntity breedEntity = new BreedEntity();
//        breedEntity.setName("breed");
//        breedEntity.setDescription("breed");
//        SubBreedEntity subBreedEntity = new SubBreedEntity();
//        subBreedEntity.setName("subbreed");
//        subBreedEntity.setDescription("subbreed");
//
//        breedEntity.getSubBreeds().add(subBreedEntity);
//        breedRepository.save(breedEntity);
//
//        return null;
//    }
//}
//public class Initializer implements ApplicationRunner {
//    private BreedRepository breedRepository;
//    private SubBreedRepository subBreedRepository;
//
//    @Autowired
//    public Initializer(BreedRepository breedRepository, SubBreedRepository subBreedRepository){
//        this.breedRepository = breedRepository;
//        this.subBreedRepository = subBreedRepository;
//    }
//
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//    }
//}

@Component
public class Initializer {
    @Bean
    public ApplicationRunner init(
            BreedRepository breedRepository,
            SubBreedRepository subBreedRepository
    ) {
        if (breedRepository.findAll().size() == 0) {
            breedRepository.deleteAllInBatch();
            subBreedRepository.deleteAllInBatch();

            return args -> {
                List<BreedEntity> breedEntities = Arrays.asList(
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
                );
                breedRepository.saveAll(breedEntities);

                List<SubBreedEntity> subBreedEntities = Arrays.asList(
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
                );
                subBreedRepository.saveAll(subBreedEntities);
            };
        }
        return null;
    }
}
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
