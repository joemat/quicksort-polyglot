package de.joemat.learning.quicksort_polyglot.clojure;

import clojure.lang.IFn;
import clojure.lang.RT;
import de.joemat.learning.quicksort_polyglot.api.Sorter;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class QuicksortClojure implements Sorter {
   @Override
   public List<Integer> apply( List<Integer> unsorted, Consumer<List<Integer>> listConsumer ) {

      try {
         RT.loadResourceScript( "de/joemat/learning/quicksort_ployglot/clojure/sort.clj" );
         IFn cls = RT.var( "de.joemat.learning.quicksort_polyglot.clojure", "quicksort" );
         return (List<Integer>) cls.invoke( unsorted, listConsumer );
      }
      catch ( IOException e ) {
         e.printStackTrace();
      }

      return unsorted; // TODO better error handling
   }
}
