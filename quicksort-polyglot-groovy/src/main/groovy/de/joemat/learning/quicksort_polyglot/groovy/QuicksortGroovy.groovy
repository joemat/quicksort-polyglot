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

        List<Integer> lower, greaterEquals
        (lower, greaterEquals) = partition(remaining, pivot)
        return quicksort(lower) + pivot + quicksort(greaterEquals)
    }

    private Tuple2<List<Integer>, List<Integer>> partition(List<Integer> unsorted, Integer pivot) {
        def lower = []
        def greaterEquals = []

        unsorted.forEach{if (it < pivot ) {
            lower.add(it)
        } else {
            greaterEquals.add(it)
        }}

        Tuple2.of(lower, greaterEquals)
    }
}
