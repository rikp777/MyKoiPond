package com.api.mykoipond;


import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.SizeEntity;
import com.api.mykoipond.domain.SubBreedEntity;
import com.api.mykoipond.domain.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@TestPropertySource(locations = "classpath:application-test.yml")
@SpringBootTest
public class ModelApplicationTests {
    private List<UserEntity> userEntities = Arrays.asList(
                UserEntity.builder()
                        .firstName("Rik")
                        .lastName("Peeters")
                        .email("rik@test.nl")
                        .password("password")
                        .username("Rik")
                        .build()
    );

    private List<BreedEntity> breedEntities = Arrays.asList(
            BreedEntity.builder()
                        .name("Kohaku")
                        .description("Witte koi met rode patronen")
                        .build()
    );

    private List<SubBreedEntity> subBreedEntities = Arrays.asList(
            SubBreedEntity.builder()
                    .name("Doitsu Kohaku")
                    .description("deels geschubd of schubbenloze kohaku")
                    .breed(breedEntities.get(0))
                    .build()
    );
    private List<SizeEntity> sizeEntities = Arrays.asList(
            SizeEntity.builder()
                    .size(15)
                    .date(new Date(Calendar.getInstance().getTime().getTime()))
                    .comment("Hard Gegroeid")
                    .build()
    );

    //#region UserEntity
    @Test
    public void getUserEntityUsername(){
        String result = userEntities.get(0).getUsername();
        String expected = "Rik";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setUserEntityUsername(){
        userEntities.get(0).setUsername("newUsername");
        String result = userEntities.get(0).getUsername();
        String expected = "newUsername";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getUserEntityEmail(){
        String result = userEntities.get(0).getEmail();
        String expected = "rik@test.nl";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setUserEntityEmail(){
        userEntities.get(0).setEmail("newEmail");
        String result = userEntities.get(0).getEmail();
        String expected = "newEmail";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getUserEntityPassword(){
        String result = userEntities.get(0).getPassword();
        String expected = "password";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setUserEntityPassword(){
        userEntities.get(0).setPassword("newPassword");
        String result = userEntities.get(0).getPassword();
        String expected = "newPassword";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getUserEntityFirstnameLastName(){
        String resultFirstname = userEntities.get(0).getFirstName();
        String resultLastname = userEntities.get(0).getLastName();

        String expectedFirstname = "Rik";
        String expectedLastname = "Peeters";

        Assert.assertEquals(expectedFirstname, resultFirstname);
        Assert.assertEquals(expectedLastname, resultLastname);
    }
    //endregion

    //#region BreedEntity
    @Test
    public void getBreedEntityName(){
        String result = breedEntities.get(0).getName();
        String expected = "Kohaku";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setBreedEntityName(){
        breedEntities.get(0).setName("newName");
        String result = breedEntities.get(0).getName();
        String expected = "newName";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getBreedEntityDescription(){
        String result = breedEntities.get(0).getDescription();
        String expected = "Witte koi met rode patronen";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setBreedEntityDescription(){
        breedEntities.get(0).setDescription("newDescription");
        String result = breedEntities.get(0).getDescription();
        String expected = "newDescription";
        Assert.assertEquals(expected, result);
    }
    //endregion

    //#region SubBreedEntity
    @Test
    public void getSubBreedEntityName(){
        String result = subBreedEntities.get(0).getName();
        String expected = "Doitsu Kohaku";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setSubBreedEntityName(){
        subBreedEntities.get(0).setName("newName");
        String result = subBreedEntities.get(0).getName();
        String expected = "newName";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSubBreedEntityDescription(){
        String result = subBreedEntities.get(0).getDescription();
        String expected = "deels geschubd of schubbenloze kohaku";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setSubBreedEntityDescription(){
        subBreedEntities.get(0).setDescription("newDescription");
        String result = subBreedEntities.get(0).getDescription();
        String expected = "newDescription";
        Assert.assertEquals(expected, result);
    }
    //endregion

    //region SizeEntity
    @Test
    public void getSizeEntitySize(){
        Integer result = sizeEntities.get(0).getSize();
        Integer expected = 15;
        Assert.assertEquals(expected, result);
    }
    @Test
    public void setSizeEntitySize(){
        sizeEntities.get(0).setSize(16);
        Integer result = sizeEntities.get(0).getSize();
        Integer expected = 16;
        Assert.assertEquals(expected, result);
    }
    @Test
    public void getSizeEntityComment(){
        String result = sizeEntities.get(0).getComment();
        String expected = "Hard Gegroeid";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void SetSizeEntityComment(){
        sizeEntities.get(0).setComment("Nog een beetje gegroeid");
        String result = sizeEntities.get(0).getComment();
        String expected = "Nog een beetje gegroeid";
        Assert.assertEquals(expected, result);
    }
    //endregion
}
