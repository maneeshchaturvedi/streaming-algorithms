package com.maneesh.streamingalgo;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreMajorityTest {
    private BoyerMooreMajority boyerMooreMajority;
    @BeforeEach
    void setUp() {
        boyerMooreMajority = new BoyerMooreMajority();
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateEmptySequence() {
        Integer[] sequence = new Integer[]{};
        Integer candidate  = boyerMooreMajority.majorityCandidate(sequence);
        assertNull(candidate);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidate_SequenceOfSizeOne() {
        Integer[] sequence = new Integer[]{1001};
        Integer candidate  = boyerMooreMajority.majorityCandidate(sequence);
        assertEquals(candidate, 1001);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateIs2() {
        Integer[] sequence = new Integer[]{2,2,3,2,5,2,7,2};
        Integer candidate  = boyerMooreMajority.majorityCandidate(sequence);
        assertEquals(candidate, 2);
    }

    @org.junit.jupiter.api.Test
    void majorityCandidateDoesNotExist_CountLessThanHalf() {
        Integer[] sequence = new Integer[]{2,2,3,2,5,2,7,8};
        Integer candidate  = boyerMooreMajority.majorityCandidate(sequence);
        assertNull(candidate);
    }
    @org.junit.jupiter.api.Test
    void majorityCandidateDoesNotExist_AllDistinctElementsInSequence() {
        Integer[] sequence = new Integer[]{1,2,3,4,5,6,7,8};
        Integer candidate  = boyerMooreMajority.majorityCandidate(sequence);
        assertNull(candidate);
    }
}