package com.api.mykoipond;


import com.api.mykoipond.dao.UserRepository;
import com.api.mykoipond.domain.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@TestPropertySource(locations = "classpath:application-test.properties")
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

    @Test
    public void getUsername(){
        String result = userEntities.get(0).getUsername();
        String expected = "Rik";
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void setUsername(){
        userEntities.get(0).setUsername("newUsername");
        String result = userEntities.get(0).getUsername();
        String expected = "newUsername";
        Assert.assertEquals(expected, result);
    }
}
