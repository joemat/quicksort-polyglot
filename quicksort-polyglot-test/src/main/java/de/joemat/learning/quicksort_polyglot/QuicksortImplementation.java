package de.joemat.learning.quicksort_polyglot;

import de.joemat.learning.quicksort_polyglot.clojure.QuicksortClojureFactory;
import de.joemat.learning.quicksort_polyglot.javascript.QuicksortJavascriptFactory;
import de.joemat.learning.quicksort_polyglot.jruby.QuicksortJRubyFactory;
import de.joemat.learning.quicksort_polyglot.api.Sorter;
import de.joemat.learning.quicksort_polyglot.java.QuicksortJava;
import de.joemat.learning.quicksort_polyglot.java.QuicksortJavaStdLib;
import de.joemat.learning.quicksort_polyglot.kotlin.QuicksortKotlin;
import de.joemat.learning.quicksort_polyglot.kotlin.QuicksortKotlinStdLib;
import de.joemat.learning.quicksort_polyglot.scala.QuicksortScalaStdLib;
import de.joemat.learning.quicksort_polyglot.groovy.QuicksortGroovy;
import org.w3c.dom.css.Counter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public enum QuicksortImplementation {

    // Languages compiling to .class files
    JAVA_STDLIB(new QuicksortJavaStdLib()),
    JAVA(new QuicksortJava() ),
    KOTLIN_STDLIB(new QuicksortKotlinStdLib()),
    KOTLIN(new QuicksortKotlin()),
    SCALA_STDLIB(new QuicksortScalaStdLib()),
    GROOVY(new QuicksortGroovy()),

    // Language using a script interface
    JAVASCRIPT(QuicksortJavascriptFactory.build()),
    CLOJURE(QuicksortClojureFactory.build()),
    JRUBY(QuicksortJRubyFactory.build());

    private final Sorter sorter;
    private final AtomicInteger callbackCounter = new AtomicInteger(0);

    QuicksortImplementation(Sorter sortFunction) {
        this.sorter = sortFunction;
    }

    public List<Integer> sort(List<Integer> unsortedList) {
        return this.sorter.apply(unsortedList, this::printResult);
    }

    public void printResult(List<Integer> resultList) {
        System.out.println(name() + " => " + Arrays.toString(resultList.toArray()));
        callbackCounter.incrementAndGet();
    }

    public void resetCallbackCounter() {
        callbackCounter.set(0);
    }

    public int getCallbackCounter() {
        return callbackCounter.get();
    }
}
