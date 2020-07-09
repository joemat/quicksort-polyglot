package de.joemat.learning.quicksort_polyglot.java;

import de.joemat.learning.quicksort_polyglot.api.Sorter;

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

      return selectPivotElementAndSortAround( unsorted );
   }

   private List<Integer> selectPivotElementAndSortAround( List<Integer> unsorted ) {

      int pivotElement = unsorted.get( 0 );
      List<Integer> listWithoutPivotElement = unsorted.subList( 1, unsorted.size() );

      return sortAround( pivotElement, listWithoutPivotElement );
   }

   private List<Integer> sortAround( int pivot, List<Integer> listWithoutPivotElement ) {
      List<Integer> lowerThanPivot = new LinkedList<>();
      List<Integer> greaterThanPivot = new LinkedList<>();

      listWithoutPivotElement.stream()
                  .forEach( it -> {
                     if ( it < pivot ) {
                        lowerThanPivot.add( it );
                     }
                     else {
                        greaterThanPivot.add( it );
                     }
                  } );

      return buildListOf( lowerThanPivot, pivot, greaterThanPivot );
   }

   private List<Integer> buildListOf( List<Integer> lowerThanPivot, int pivot, List<Integer> greaterThanPivot ) {
      List<Integer> sorted = new LinkedList<>();
      sorted.addAll( sort( lowerThanPivot ) );
      sorted.add( pivot );
      sorted.addAll( sort( greaterThanPivot ) );
      return sorted;
   }
}
