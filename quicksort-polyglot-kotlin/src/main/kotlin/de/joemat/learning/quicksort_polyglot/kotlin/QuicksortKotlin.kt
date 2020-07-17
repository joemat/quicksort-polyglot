package de.joemat.learning.quicksort_polyglot.kotlin

import de.joemat.learning.quicksort_polyglot.api.Sorter
import java.util.function.Consumer

class QuicksortKotlin : Sorter {
    override fun apply(unsorted: MutableList<Int>, resultHandler: Consumer<MutableList<Int>>): MutableList<Int> {
        val sorted =quicksort(unsorted)
        resultHandler.accept(sorted.toMutableList())
        return sorted.toMutableList()
    }

    private fun quicksort(unsorted: List<Int>) : List<Int>{
        if (unsorted.size < 2) {
            return unsorted;
        }
        var pivot = unsorted.first();
        var tail = unsorted.subList(1, unsorted.size )
        var (lessThan, greaterThan) = tail.partition { it <= pivot }
        return quicksort(lessThan) + pivot + quicksort(greaterThan)
    }
}