package com.api.mykoipond;

import com.api.mykoipond.dao.BreedRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.yml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class BreedTests {

    @Autowired
    private BreedRepository breedRepository;

    @Test
    public void BreedCount(){
        int result = breedRepository.breedsWithCount().size();
        System.out.println("found tables: " + result);
        int expected = 7;
        Assert.assertEquals(expected, result);
    }
}
