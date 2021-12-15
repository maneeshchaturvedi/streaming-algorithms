package com.maneesh.streamingalgo;


import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MisraGriesTest {

    @Test
    void query_Top2FreqElements() {
        Stream<Integer> stream = Stream.of(1,5,2,4,2,4,3,4,2,4,5,4,5,3,2,5,4,5,5,4);
        int k = 2;
        MisraGries mg = new MisraGries(stream, k);

        Set<Integer> keys = mg.keys();
        assertEquals(keys.size(), 2);
        assertTrue(keys.contains(4));
        assertTrue(keys.contains(5));
        assertFalse(keys.contains(2));
        assertFalse(keys.contains(3));
        assertFalse(keys.contains(1));


        Long freq = mg.query(4);
        assertEquals(freq, 7);
        freq = mg.query(5);
        assertEquals(freq, 6);

        freq = mg.query(2);
        assertNull(freq);

        freq = mg.query(3);
        assertNull(freq);

        freq = mg.query(1);
        assertNull(freq);


    }
    @Test
    void query_Top4FreqElements() {
        Stream<Integer> stream = Stream.of(1,5,2,4,2,4,3,4,2,4,5,4,5,3,2,5,4,5,5,4);
        int k = 4;
        MisraGries mg = new MisraGries(stream, k);

        Set<Integer> keys = mg.keys();
        assertEquals(keys.size(), 4);
        assertTrue(keys.contains(4));
        assertTrue(keys.contains(5));
        assertTrue(keys.contains(2));
        assertTrue(keys.contains(3));
        assertFalse(keys.contains(1));

        Long freq = mg.query(4);
        assertEquals(freq, 7);
        freq = mg.query(5);
        assertEquals(freq, 6);
        freq = mg.query(2);
        assertEquals(freq,4);

        freq = mg.query(3);
        assertEquals(freq,2);

        freq = mg.query(1);
        assertNull(freq);


    }

}