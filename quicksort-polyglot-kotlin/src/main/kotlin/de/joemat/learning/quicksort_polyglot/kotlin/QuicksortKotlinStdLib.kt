package de.joemat.learning.quicksort_polyglot.kotlin

import de.joemat.learning.quicksort_polyglot.api.Sorter
import java.util.function.Consumer

class QuicksortKotlinStdLib : Sorter {
    override fun apply(unsorted: MutableList<Int>, resultHandler: Consumer<MutableList<Int>>): MutableList<Int> {
        val sorted = unsorted.sorted()
        resultHandler.accept(sorted.toMutableList())
        return sorted.toMutableList()
    }
}