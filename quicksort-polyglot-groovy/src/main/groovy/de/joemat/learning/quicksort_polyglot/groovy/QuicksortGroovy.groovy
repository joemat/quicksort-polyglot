package de.joemat.learning.quicksort_polyglot.groovy

import de.joemat.learning.quicksort_polyglot.api.Sorter

import java.util.function.Consumer

class QuicksortGroovy implements Sorter {

    @Override
    List<Integer> apply(List<Integer> unsorted, Consumer<List<Integer>> resultHandler) {
        def sorted = quicksort(unsorted)
        resultHandler.accept(sorted)
        return sorted
    }

    private List<Integer> quicksort(List<Integer> unsorted) {
        if (unsorted.size() <= 1) {
            return unsorted
        }
        def pivot = unsorted.first()
        def remaining = unsorted.tail()
        def lower = remaining.findAll { it < pivot }
        def greaterEquals = remaining.findAll { it >= pivot }
        return quicksort(lower) + pivot + quicksort(greaterEquals)
    }
}
