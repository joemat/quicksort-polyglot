package de.joemat.learning.quicksort_polyglot.java;

import de.joemat.learning.quicksort_polyglot.api.Sorter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class QuicksortJavaStdLib implements Sorter {

    @Override
    public List<Integer> apply(List<Integer> unsorted, Consumer<List<Integer>> resultHandler) {
        Integer[] arrayToBeSorted = unsorted.toArray(new Integer[0]);
        Arrays.sort(arrayToBeSorted);
        List<Integer> sortedList = Arrays.asList(arrayToBeSorted);
        resultHandler.accept(sortedList);
        return sortedList;
    }
}
