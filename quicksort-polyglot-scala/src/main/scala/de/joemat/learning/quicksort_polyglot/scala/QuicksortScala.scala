package de.joemat.learning.quicksort_polyglot.scala

import java.util
import java.util.function.Consumer

import de.joemat.learning.quicksort_polyglot.api.Sorter

import scala.jdk.CollectionConverters._

class QuicksortScala extends Sorter {
  override def apply(unsorted: util.List[Integer], resultHandler: Consumer[util.List[Integer]]): util.List[Integer] = {
    val sorted = quicksortImpl(unsorted.asScala.toList)
    resultHandler.accept(sorted.asJava)
    sorted.asJava
  }

  def quicksortImpl(unsorted: List[Integer]): List[Integer] = {
    if (unsorted.size <= 1) {
      return unsorted
    }

    val pivot = unsorted.head
    val remaining = unsorted.tail
    val (lower, greaterOrEquals) = remaining.partition {
      _ < pivot
    }
    quicksortImpl(lower) ++ List(pivot) ++ quicksortImpl(greaterOrEquals)
  }
}
