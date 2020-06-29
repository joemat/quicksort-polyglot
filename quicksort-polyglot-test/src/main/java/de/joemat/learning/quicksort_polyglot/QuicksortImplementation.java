package de.joemat.learning.quicksort_polyglot;

import de.joemat.learning.quicksort_polyglot.api.Sorter;
import de.joemat.learning.quicksort_polyglot.java.QuicksortJavaStdLib;

import java.util.Arrays;
import java.util.List;

public enum QuicksortImplementation {

    JAVA_STDLIB(new QuicksortJavaStdLib());

    private final Sorter sorter;

    QuicksortImplementation(Sorter sortFunction) {
        this.sorter = sortFunction;
    }

    public List<Integer> sort(List<Integer> unsortedList) {
        return this.sorter.apply(unsortedList, this::printResult);
    }

    public void printResult(List<Integer> resultList) {
        System.out.println(name() + " => " + Arrays.toString(resultList.toArray()));
    }
}
