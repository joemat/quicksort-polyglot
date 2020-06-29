package de.joemat.learning.quicksort_polyglot.scala

import java.util
import java.util.function.Consumer

import de.joemat.learning.quicksort_polyglot.api.Sorter

import scala.jdk.CollectionConverters._

class QuicksortScalaStdLib extends Sorter {
  override def apply(unsorted: util.List[Integer], resultHandler: Consumer[util.List[Integer]]): util.List[Integer] = {
    val sorted = unsorted.asScala.sorted
    resultHandler.accept(sorted.asJava)
    sorted.asJava
  }
}
