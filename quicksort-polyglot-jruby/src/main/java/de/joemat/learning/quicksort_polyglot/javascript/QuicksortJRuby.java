package de.joemat.learning.quicksort_polyglot.javascript;

import de.joemat.learning.quicksort_polyglot.api.Sorter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

public class QuicksortJRuby implements Sorter {
    @Override
    public List<Integer> apply(List<Integer> integers, Consumer<List<Integer>> listConsumer) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("jruby");

        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("QuicksortJRubyImpl.rb");
        try {
            engine.eval(new InputStreamReader(resource));
            Object quicksort = engine.get("quicksort");
            if (quicksort instanceof Sorter) {
                Sorter sorter = (Sorter) quicksort;
                return sorter.apply(integers, listConsumer);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return integers; // TODO better error handling
    }
}
