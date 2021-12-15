package com.maneesh.streamingalgo;

import java.util.*;
import java.util.stream.Stream;

public class MisraGries {
    private final Map<Integer, Integer> associativeArr;
    private final int k;
    private final Integer[] sequence;

    public MisraGries(Stream<Integer> stream, int k) {

        associativeArr = new HashMap<>();
        this.k = k;
        this.sequence = stream.toArray(Integer[]::new);
        populateAssociativeArr();
    }

    public Set<Integer> keys() {
        return associativeArr.keySet();
    }
    public Integer query(Integer element) {
        if (associativeArr.containsKey(element)) {
            return freq(element);
        }
        return null;
    }

    private Integer freq(Integer element) {
        Integer freq = 0;
        for(Integer x : sequence ){
            if(x.equals(element)){
                freq++;
            }
        }
        return freq;
    }

    private void populateAssociativeArr() {
        if (sequence == null || sequence.length == 0) return;
        for (int element : sequence) {
            if (associativeArr.containsKey(element)) {
                int elementCounter = associativeArr.get(element);
                associativeArr.put(element, elementCounter + 1);
            } else if (associativeArr.size() < k)  {
                associativeArr.put(element, 1);
            } else {
                Iterator<Integer> iter = associativeArr.keySet().iterator();
                while (iter.hasNext()) {
                    Integer currentKey = iter.next();
                    Integer currentCount = associativeArr.get(currentKey);
                    associativeArr.put(currentKey, currentCount - 1);
                    if (associativeArr.get(currentKey) == 0) {
                        iter.remove();
                    }
                }
            }
        }
    }


}
