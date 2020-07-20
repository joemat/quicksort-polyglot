package de.joemat.learning.quicksort_polyglot.javascript;

import de.joemat.learning.quicksort_polyglot.api.Sorter;
import de.joemat.learning.quicksort_polyglot.scripted.ScriptedSorterFactory;

public class QuicksortJavascriptFactory {

    private QuicksortJavascriptFactory() {
        // disabled
    }

    public static Sorter build() {
        ScriptedSorterFactory factory = new ScriptedSorterFactory();
        factory.setInterpreterLanguage("javascript");
        factory.setScriptFile("QuicksortJavascript.js");
        factory.setObjectName("quicksort");
        return factory.build();
    }
}
