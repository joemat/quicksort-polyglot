package de.joemat.learning.quicksort_polyglot.java;

import de.joemat.learning.quicksort_polyglot.api.Sorter;
import org.javatuples.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class QuicksortJava implements Sorter {

   @Override
   public List<Integer> apply( List<Integer> unsorted, Consumer<List<Integer>> resultHandler ) {
      List<Integer> sorted = sort( unsorted );
      resultHandler.accept( sorted );
      return sorted;
   }

   public List<Integer> sort( List<Integer> unsorted ) {
      if ( unsorted.size() <= 1 ) {
         return unsorted; // nothing to do
      }

      int pivot = unsorted.get( 0 );
      List<Integer> tail = unsorted.subList( 1, unsorted.size() );

      Pair<List<Integer>, List<Integer>> partitioned = partition( tail, pivot );
      List<Integer> lower = partitioned.getValue0();
      List<Integer> greaterEquals = partitioned.getValue1();

      return buildListOf( sort( lower ), pivot, sort( greaterEquals ) );
   }

   private Pair<List<Integer>, List<Integer>> partition( List<Integer> unsorted, int pivot ) {
      List<Integer> lower = new LinkedList<>();
      List<Integer> greaterEquals = new LinkedList<>();

      unsorted.stream().forEach( it -> {
         if ( it < pivot ) {
            lower.add( it );
         }
         else {
            greaterEquals.add( it );
         }
      } );
      return Pair.with( lower, greaterEquals );
   }

   private List<Integer> buildListOf( List<Integer> lowerThanPivot, int pivot, List<Integer> greaterThanPivot ) {
      List<Integer> sorted = new LinkedList<>();
      sorted.addAll( lowerThanPivot );
      sorted.add( pivot );
      sorted.addAll( greaterThanPivot );
      return sorted;
   }
}
