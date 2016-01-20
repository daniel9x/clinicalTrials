package edu.emory.clinical.trials.webapp.server.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public final class RestApplication extends Application {

    public RestApplication() throws InstantiationException {
        RestServerConfigurator.init();
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ClinicalTrialsRestService.class);
        classes.add(SmokeTest.class);
        return classes;
    }
}
