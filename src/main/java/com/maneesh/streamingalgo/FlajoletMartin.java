package com.maneesh.streamingalgo;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class FlajoletMartin<T> {

    private int L;
    private final BitSet bitset;

    public FlajoletMartin(int L) {
        this.L = L;
        this.bitset = new BitSet(2 ^ L);
    }

    private String hash(T element) {


        int hashMult = 0;
        do{
            hashMult = (int)(Math.random() * Integer.MAX_VALUE);
        }while(hashMult % 2 == 0);
        int hashConst = 0;
        do{
            hashConst = (int)(Math.random() * Integer.MAX_VALUE);
        }while(hashConst % 2 == 0);


        long modulo = (long) Math.pow(2.0,L);
        long hash = (hashMult * element.hashCode() + hashConst) % modulo;

        return String.valueOf(hash);
    }

    public long countDistinct(Stream<T> stream) {
        stream.forEach(
                element -> {

                    String hash = hash(element);

                    BigInteger val = new BigInteger(hash);

                    int lowestSetBit = val.getLowestSetBit();
                    if (lowestSetBit > 0) {
                        bitset.set(lowestSetBit);
                    }

                }
        );
        int R = bitset.length();
        System.out.println("bitset=" + bitset);
        return (int) Math.pow(2.0, R);
    }
}
