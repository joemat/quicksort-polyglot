package de.joemat.learning.quicksort_polyglot.api;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public interface Sorter extends BiFunction<List<Integer>, Consumer<List<Integer>>, List<Integer>> {
}
