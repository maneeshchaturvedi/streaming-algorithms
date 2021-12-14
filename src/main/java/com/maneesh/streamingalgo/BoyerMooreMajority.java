package com.maneesh.streamingalgo;

/**
 * An implementation of the Boyer-Moore Majority Algorithm
 */
public class BoyerMooreMajority {
    public Integer majorityCandidate(Integer [] sequence){
        if(sequence == null || sequence.length == 0)return null;

        Integer candidate = null;
        int counter = 0;

        for (Integer element:sequence) {
            if(counter == 0){
                candidate = element;
                counter++;
            }else if(element.equals(candidate)){
                counter++;
            }else{
                counter--;
            }
        }

        counter = 0;
        for(Integer element : sequence){
            if(element.equals(candidate)){
                counter++;
            }
        }
        if(counter > sequence.length / 2)   return candidate;
        return null;

    }

}
