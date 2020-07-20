package de.joemat.learning.quicksort_polyglot.clojure;

import clojure.lang.IFn;
import clojure.lang.RT;
import de.joemat.learning.quicksort_polyglot.api.Sorter;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class QuicksortClojureFactory {

    public static final String CLOJURE_FILE = "de/joemat/learning/quicksort_ployglot/clojure/sort.clj";
    public static final String CLOJURE_PACKAGE = "de.joemat.learning.quicksort_polyglot.clojure";
    public static final String CLOJURE_OBJECT_NAMNE = "quicksort";

    private QuicksortClojureFactory() {
        // private
    }

    public static Sorter build() {
        try {
            return tryBuild();
        } catch (IOException e) {
            throw new RuntimeException("Error while building clojure object", e);
        }
    }


    private static Sorter tryBuild () throws IOException {
        RT.loadResourceScript(CLOJURE_FILE);
        return wrapToSorterInterface(RT.var(CLOJURE_PACKAGE, CLOJURE_OBJECT_NAMNE));
    }

    private static Sorter wrapToSorterInterface(IFn clojureObject) {
        return (unsorted, listConsumer) -> (List<Integer>) clojureObject.invoke(unsorted, listConsumer);
    }
}
