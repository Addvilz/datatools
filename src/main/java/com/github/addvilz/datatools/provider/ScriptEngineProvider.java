package com.github.addvilz.datatools.provider;

import com.github.addvilz.datatools.api.PublicApi;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineProvider implements Provider<ScriptEngine> {
    private final ScriptEngineManager scriptEngineManager;
    private final PublicApi publicApi;

    @Inject
    public ScriptEngineProvider(ScriptEngineManager scriptEngineManager, PublicApi publicApi) {
        this.scriptEngineManager = scriptEngineManager;
        this.publicApi = publicApi;
    }

    @Override
    public ScriptEngine get() {
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        engine.put("publicApi", publicApi);
        return engine;
    }
}
