package de.joemat.learning.quicksort_polyglot;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuickSort {
    public List<Integer> unsorted = Arrays.asList(10,4,9,8,7,0,6,5,1,2,3);

    public List<Integer> sorted=Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void sortList(QuicksortImplementation impl) {
        assertEquals(sorted, impl.sort(unsorted));
    }
}
