package com.maneesh.streamingalgo;

/**
 * An implementation of the Boyer-Moore Majority Algorithm
 */
public class BoyerMooreMajority {
    public Integer majorityCandidate(Integer [] sequence){
        if(sequence == null || sequence.length == 0)return null;
        //Phase 1:
        //Initialization
        Integer candidate = null;
        int counter = 0;
        //Processing
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
        //Without phase 2 we return a potential candidate,
        // which may or may not be correct.
        //However we need to check whether the candidate is valid.
        //Phase 2:
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
