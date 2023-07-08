package com.github.orionlibs.project_name;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class NewClass
{
    private final static Logger log;

    static
    {
        log = Logger.getLogger(NewClass.class.getName());
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
