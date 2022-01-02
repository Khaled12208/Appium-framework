package com.appiumframwrok.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;


public class Helpers {

    public URL getURL(String fileName)
    {
        return getClass().getClassLoader().getResource(fileName);
    }

    public Logger log() {

        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

    }
}
