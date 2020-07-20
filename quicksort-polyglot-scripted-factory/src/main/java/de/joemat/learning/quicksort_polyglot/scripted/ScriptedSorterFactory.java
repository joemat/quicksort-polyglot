package de.joemat.learning.quicksort_polyglot.scripted;

import de.joemat.learning.quicksort_polyglot.api.Sorter;
import lombok.Setter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Setter
public class ScriptedSorterFactory {

    String interpreterLanguage;
    String scriptFile;
    String objectName;


    public Sorter build() {
        try {
            return tryBuild();
        } catch (ScriptException e) {
            throw new RuntimeException("Error build ruby sorter", e);
        }
    }

    private Sorter tryBuild() throws ScriptException {
        ScriptEngine scriptEngine = getScriptEngineFor(interpreterLanguage);
        Object quicksort = buildScriptedSorter(scriptEngine, scriptFile, objectName);
        return ensureSorterInterfaceIsImplemented(quicksort);
    }

    private Sorter ensureSorterInterfaceIsImplemented(Object quicksort) {
        if (!(quicksort instanceof Sorter)) {
            throw new RuntimeException("Object does not implement Sorter interface!");
        }
        return (Sorter) quicksort;
    }

    private Object buildScriptedSorter(ScriptEngine engine, String filename, String objectName) throws ScriptException {
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream(filename);
        engine.eval(new InputStreamReader(resource));
        return engine.get(objectName);
    }

    private ScriptEngine getScriptEngineFor(String interpreterLanguage) {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName(interpreterLanguage);
    }
}
