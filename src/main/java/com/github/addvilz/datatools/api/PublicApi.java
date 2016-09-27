package com.github.addvilz.datatools.api;

import com.github.addvilz.datatools.api.api.InputOutputApi;
import com.github.addvilz.datatools.api.api.SystemApi;
import com.google.inject.Inject;

public class PublicApi {
    public final InputOutputApi io;
    public final SystemApi system;

    @Inject
    public PublicApi(InputOutputApi io, SystemApi system) {
        this.io = io;
        this.system = system;
    }
}
