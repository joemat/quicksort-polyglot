package de.joemat.learning.quicksort_polyglot;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestQuickSort {
    public List<Integer> unsorted = Arrays.asList(10,4,9,8,7,0,6,5,1,2,3);

    public List<Integer> sorted=Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void sortList(QuicksortImplementation impl) {
        assertIterableEquals(sorted, impl.sort(unsorted));
    }

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void ensureCallbackIsCalled(QuicksortImplementation impl) {
        impl.resetCallbackCounter();
        assertIterableEquals(sorted, impl.sort(unsorted));
        assertEquals(1, impl.getCallbackCounter());
    }

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void sortListWithOneElement(QuicksortImplementation impl) {
        assertIterableEquals(Collections.singletonList(5), impl.sort(Collections.singletonList(5)));
    }

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void sortListWithSameElements(QuicksortImplementation impl) {
        assertIterableEquals(Arrays.asList( 5, 5 ), impl.sort(Arrays.asList( 5, 5 )));
    }

    @ParameterizedTest
    @EnumSource(QuicksortImplementation.class)
    public void sortListEmtpyList(QuicksortImplementation impl) {
        assertIterableEquals(Collections.emptyList(), impl.sort(Collections.emptyList()));
    }
}
