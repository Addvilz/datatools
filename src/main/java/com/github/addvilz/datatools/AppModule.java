package com.github.addvilz.datatools;

import com.github.addvilz.datatools.api.PublicApi;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.github.addvilz.datatools.provider.CommanderProvider;
import com.github.addvilz.datatools.provider.ScriptEngineProvider;
import com.rfksystems.commander.Commander;

import javax.script.ScriptEngine;

class AppModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder
                .bind(Commander.class)
                .toProvider(CommanderProvider.class)
                .in(Singleton.class)
        ;

        binder
                .bind(ScriptEngine.class)
                .annotatedWith(Names.named("nashorn"))
                .toProvider(ScriptEngineProvider.class)
        ;

        binder
                .bind(PublicApi.class)
                .in(Singleton.class)
        ;
    }
}
