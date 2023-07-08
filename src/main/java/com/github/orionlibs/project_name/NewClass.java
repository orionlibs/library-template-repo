package com.github.orionlibs.project_name;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class NewClass
{
    private final static Logger log;
    //private final Environment springEnv;
    //private final OrionConfiguration featureConfiguration;

    static
    {
        log = Logger.getLogger(NewClass.class.getName());
    }
    
    
    @Autowired
    public NewClass(final Environment springEnv) throws IOException
    {
        this.springEnv = springEnv;
        this.featureConfiguration = OrionConfiguration.loadFeatureConfiguration(springEnv);
        loadLoggerConfiguration();
        ConfigurationService.registerConfiguration(featureConfiguration);
    }
    
    
    private void loadLoggerConfiguration() throws IOException
    {
        LogManager.getLogManager().readConfiguration(OrionConfiguration.loadLoggerConfigurationAndGet(springEnv).getAsInputStream());
    }
    

    static void addLogHandler(Handler handler)
    {
        log.addHandler(handler);
    }


    static void removeLogHandler(Handler handler)
    {
        log.removeHandler(handler);
    }
}
