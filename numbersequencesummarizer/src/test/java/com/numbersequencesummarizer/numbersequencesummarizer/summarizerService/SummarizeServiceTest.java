package com.numbersequencesummarizer.numbersequencesummarizer.summarizerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SummarizeServiceTest {

    @Autowired
    private summarizerService service;

    @Test
    public void testThatNumberAreSummarized() {
        String inputNumberSet = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedResult = "1,3,6-8,12-15,21-24,31";

        Assertions.assertEquals(service.summarizeCollection(inputNumberSet), expectedResult);
    }
    
}
