package com.appiumframwrok.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropFile {

    private Properties prop = new Properties();
    private Helpers help = new Helpers();
    private InputStream stream;

    public PropFile(String proertiesFilePath) {
        stream = getClass().getClassLoader().getResourceAsStream(proertiesFilePath);
        try {
            prop.load(stream);
            help.log().info("File " + proertiesFilePath + " loaded successfully");
        } catch (IOException e) {
            help.log().fatal("File " + proertiesFilePath + " couldn't");
            e.printStackTrace();
        } finally {
            try {
                stream.close();
                help.log().info("File " + proertiesFilePath + " input stream closed");
            } catch (IOException e) {
                help.log().info("File " + proertiesFilePath + " didn't close");
                e.printStackTrace();
            }
        }

    }

    public String getProperty(String propertyKey) {
        return prop.getProperty(propertyKey);

    }
}
