package com.maneesh.streamingalgo;

import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreMajorityTest {
    private BoyerMooreMajority boyerMooreMajority;
    @BeforeEach
    void setUp() {
        boyerMooreMajority = new BoyerMooreMajority();
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateEmptySequence() {

        Stream<Integer> stream = Stream.of(new Integer[]{});
        Integer candidate  = boyerMooreMajority.majorityCandidate(stream);
        assertNull(candidate);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidate_SequenceOfSizeOne() {

        Stream<Integer> stream = Stream.of(new Integer[]{1001});
        Integer candidate  = boyerMooreMajority.majorityCandidate(stream);
        assertEquals(candidate, 1001);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateIs2() {
        Stream<Integer> stream = Stream.of(2,2,3,2,5,2,7,2);
        Integer candidate  = boyerMooreMajority.majorityCandidate(stream);
        assertEquals(candidate, 2);
    }

    @org.junit.jupiter.api.Test
    void majorityCandidateDoesNotExist_CountLessThanHalf() {
        Stream<Integer> stream = Stream.of(2,2,3,2,5,2,7,8);
        Integer candidate  = boyerMooreMajority.majorityCandidate(stream);
        assertNull(candidate);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateDoesNotExist_AllDistinctElementsInSequence() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8);
        Integer candidate  = boyerMooreMajority.majorityCandidate(stream);
        assertNull(candidate);
    }
}