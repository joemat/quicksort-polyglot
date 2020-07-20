package de.joemat.learning.quicksort_polyglot.jruby;

import de.joemat.learning.quicksort_polyglot.api.Sorter;
import de.joemat.learning.quicksort_polyglot.scripted.ScriptedSorterFactory;

public final class QuicksortJRubyFactory {

    private QuicksortJRubyFactory() {
        // disabled
    }

    public static Sorter build() {
        ScriptedSorterFactory factory = new ScriptedSorterFactory();
        factory.setInterpreterLanguage("jruby");
        factory.setScriptFile("QuicksortJRubyImpl.rb");
        factory.setObjectName("quicksort");
        return factory.build();
    }
}
