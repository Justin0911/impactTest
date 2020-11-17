package com.numbersequencesummarizer.numbersequencesummarizer.sequenceSummary;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NumberRangeSummarizerTest {

    @Autowired
    private numberRangeSummarizer numberRangeSummarizer;

    @Test
    public void testNumbersetSize() {
        Assertions.assertEquals(numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31").size(), 14);
    }

    @Test
    public void testStringSplit() {
        Collection<Integer> numberSet = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Assertions.assertFalse(numberSet.isEmpty());
        Assertions.assertEquals(numberSet.iterator().hasNext(), true);
    }

    @Test
    public void testNumberSetSequential() {

        Collection<Integer> numberSet = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Assertions.assertFalse(Boolean.parseBoolean(Arrays.stream(numberSet.toArray()).unordered().toString()));
    }

    @Test
    public void testNumberSetSummarized() {
        String inputNumberSet = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedResult = "1,3,6-8,12-15,21-24,31";

        Collection<Integer> numberSet = numberRangeSummarizer.collect(inputNumberSet);

        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberSet), expectedResult);
    }
    
}
