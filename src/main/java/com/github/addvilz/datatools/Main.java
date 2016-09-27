package com.github.addvilz.datatools;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rfksystems.commander.Commander;
import com.rfksystems.commander.exception.CommandUnknownException;
import com.rfksystems.commander.exception.InputParseException;
import com.rfksystems.commander.exception.NoCommandGivenException;
import com.rfksystems.commander.exception.RuntimeArgumentException;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        int code = -1;
        try {
            code = injector
                    .getInstance(Commander.class)
                    .execute(args)
            ;
        } catch (NoCommandGivenException | CommandUnknownException | RuntimeArgumentException | InputParseException e) {
            e.printStackTrace();
        }
        System.exit(code);
    }
}
