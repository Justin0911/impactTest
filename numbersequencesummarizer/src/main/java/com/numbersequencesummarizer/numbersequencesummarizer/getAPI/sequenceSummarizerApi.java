package com.numbersequencesummarizer.numbersequencesummarizer.getAPI;

import com.numbersequencesummarizer.numbersequencesummarizer.summarizerService.summarizerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sequenceSummarizerApi {

    @Autowired
    private summarizerService service;

    /**
     * @request http://localhost:8080/sequenceSummary/numberSet?num=1,3,6,7,8,12,13,14,15,21,22,23,24,31
     * @param num
     * @return string
     */

     @GetMapping("/sequenceSummary/numberSet") 
     @ResponseBody
     public String getNumberSetSummary(@RequestParam String num) {
         return service.summarizeCollection(num);
     }

     @GetMapping("/")
     @ResponseBody
     public String homeHeading() {
         return "<h2>Numberset split into sequence summary</h2>";
     }
}