package com.github.addvilz.datatools.command;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.github.addvilz.datatools.api.PublicApi;
import com.rfksystems.commander.Command;
import com.rfksystems.commander.Input;
import com.rfksystems.commander.exception.RuntimeArgumentException;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

public class ScriptCommand implements Command {
    private final ScriptEngine scriptEngine;
    private final PublicApi publicApi;

    @Inject
    public ScriptCommand(@Named("nashorn") ScriptEngine scriptEngine, PublicApi publicApi) {
        this.scriptEngine = scriptEngine;
        this.publicApi = publicApi;
    }

    @Override
    public String getName() {
        return "script";
    }

    @Override
    public String[] getUsage() {
        return new String[]{
                "datatools script <file> <...args>"
        };
    }

    @Override
    public String getDescription() {
        return "Execute given script";
    }

    @Override
    public int execute(Input input, PrintStream printStream) throws RuntimeArgumentException {
        try {
            FileReader scriptFileReader = new FileReader(input.positional.get(0));
            Bindings simpleBindings = new SimpleBindings();
            simpleBindings.put("input", input);
            simpleBindings.put("api", publicApi);
            scriptEngine.eval(scriptFileReader, simpleBindings);
        } catch (FileNotFoundException e) {
            throw new RuntimeArgumentException(String.format("Script not found: %s", input.positional.get(0)));
        } catch (ScriptException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
