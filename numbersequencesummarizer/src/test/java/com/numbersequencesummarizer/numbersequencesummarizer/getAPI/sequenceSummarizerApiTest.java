package com.numbersequencesummarizer.numbersequencesummarizer.getAPI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.numbersequencesummarizer.numbersequencesummarizer.NumbersequencesummarizerApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = NumbersequencesummarizerApplication.class)
@AutoConfigureMockMvc
public class sequenceSummarizerApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSuccessOfRequestAndResponse() throws Exception {

        String inputNumberSet = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String ExpectedResult = "1,3,6-8,12-15,21-24,31";

        mvc.perform(get("/sequenceSummary/numberSet?num="+ inputNumberSet))
                .andExpect(status().isOk())
                .andExpect(content().string(ExpectedResult));
    } 
}