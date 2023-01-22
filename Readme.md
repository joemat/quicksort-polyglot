# Quicksort polyglot

![Build with Gradle](https://github.com/joemat/quicksort-polyglot/workflows/Java%20CI%20with%20Gradle/badge.svg)

This is my personal project to learn how to 
integrate different languages with Java.

The API interface [Sorter](quicksort-polyglot-api/src/main/java/de/joemat/learning/quicksort_polyglot/api/Sorter.java) is to be implemented in different languages.

The interface is build in a way that data is passed to the implementation and back to Java.
It also passes a callback implementation that is supposed to be called by the implementation
(just to learn how to call Java from other languages).

There is a test suite [TestQuickSort](quicksort-polyglot-test/src/test/java/de/joemat/learning/quicksort_polyglot/TestQuickSort.java)
to validate the various implementations.

Just add your implementation to the [QuicksortImplementation enum](quicksort-polyglot-test/src/main/java/de/joemat/learning/quicksort_polyglot/QuicksortImplementation.java)
to add it to the test suite.

I also use it as a skeleton for katas - playing around with different languages and learn how they interact.

