package com.numbersequencesummarizer.numbersequencesummarizer.summarizerService.implementation;

import com.numbersequencesummarizer.numbersequencesummarizer.sequenceSummary.numberRangeSummarizer;
import com.numbersequencesummarizer.numbersequencesummarizer.summarizerService.summarizerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummarizerServiceImplementation implements summarizerService {
    
    @Autowired
    private numberRangeSummarizer numberRangeSummarizer;

    @Override
    public String summarizeCollection(String input) {
        return numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(input));

    }
}