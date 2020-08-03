package de.joemat.learning.quicksort_polyglot.groovy

import de.joemat.learning.quicksort_polyglot.api.Sorter
import java.util.function.Consumer

class QuicksortGroovyStdLib implements Sorter {

    @Override
    List<Integer> apply(List<Integer> unsorted, Consumer<List<Integer>> resultHandler) {
        def sorted = unsorted.sort()
        resultHandler.accept(sorted)
        return sorted
    }
}
