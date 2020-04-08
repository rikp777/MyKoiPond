package com.api.mykoipond.seeder;

import com.api.mykoipond.dao.BreedRepository;
import com.api.mykoipond.dao.RoleRepository;
import com.api.mykoipond.dao.SubBreedRepository;
import com.api.mykoipond.dao.UserRepository;
import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.RoleEntity;
import com.api.mykoipond.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

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
    public ApplicationRunner initb(BreedRepository repository) {
        if(repository.findAll().size() == 0){
            return args -> repository.saveAll(Arrays.asList(
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
            ));
        }
        return null;
    }

    @Bean
    public ApplicationRunner initr(RoleRepository repository) {
        if(repository.findAll().size() == 0){
            return args -> repository.saveAll(Arrays.asList(
                    //1
                    RoleEntity.builder()
                            .name("ADMIN")
                            .build(),
                    //2
                    RoleEntity.builder()
                            .name("USER")
                            .build()
            ));
        }
        return null;
    }

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Bean
    public ApplicationRunner initu(UserRepository repository) {
        if(repository.findAll().size() == 0){
            return args -> repository.saveAll(Arrays.asList(
                    //1
                    UserEntity.builder()
                            .firstName("Rik")
                            .lastName("Peeters")
                            .username("rik")
                            .password(bCryptPasswordEncoder.encode("secret"))
                            .active(true)
                            .email("rik@rik.com")
                            .build()
            ));
        }
        return null;
    }
}
