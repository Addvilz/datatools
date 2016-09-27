package com.github.addvilz.datatools.provider;

import com.github.addvilz.datatools.command.ScriptCommand;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rfksystems.commander.Commander;

public class CommanderProvider implements Provider<Commander> {
    private final ScriptCommand scriptCommand;

    @Inject
    public CommanderProvider(ScriptCommand scriptCommand) {
        this.scriptCommand = scriptCommand;
    }

    @Override
    public Commander get() {
        Commander commander = new Commander();
        commander.addCommand(this.scriptCommand);
        return commander;
    }
}
