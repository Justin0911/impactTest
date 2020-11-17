package com.numbersequencesummarizer.numbersequencesummarizer.sequenceSummary.implementation;

import com.numbersequencesummarizer.numbersequencesummarizer.sequenceSummary.numberRangeSummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/** 
 * @author Justin
 *Interface is implemented from numberRangeSummarizer. Takes input which consists of a comma delimited list of numbers, returns numbers 
 *in range if they are sequential. 
 */

 @Component
public class numberRangeSummarizerImplementation implements numberRangeSummarizer {

    private int indexIncrementation = 0;
    private boolean Sequential;
    private int curNumber = 0;
    private int nextNumber = 0;

    @Override
    public final Collection<Integer> collect(String input) {
        return Arrays.stream(input.split("[,]"))
                .filter(number -> number.matches("^[0-9]*$"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }    
    
    @Override
    public final String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> numberSet = new ArrayList<>(input);
        String str = numberSet.get(0).toString();

        return numberSetSummary(numberSet, indexIncrementation, str);
    }

    private String numberSetSummary(ArrayList<Integer> numberSet, int i, String str){
        curNumber = (numberSet.get(i)+1);
        nextNumber = numberSet.get(i+1);

        if(curNumber == nextNumber){
            i++;
            Sequential = true;
        }
        else if(Sequential) {
            str += "-"+ numberSet.get(i);
            i++;
            str += (","+ numberSet.get(i));
            Sequential = false;
        }
        else {
            Sequential = false;
            i++;
            str += ","+ numberSet.get(i);
        }
        return (i <= numberSet.size()-2 ? numberSetSummary(numberSet, i, str) : str) ;
    }
}