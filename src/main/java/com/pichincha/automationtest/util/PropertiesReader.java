package com.pichincha.automationtest.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public String getPropiedad(String atributopro) {
        InputStream imputStream = null;
        Properties properties = new Properties();
        try {
            imputStream = PropertiesReader.class.getClassLoader().getResourceAsStream("properties/manualtest.properties");
            properties.load(imputStream);
        } catch (IOException e) {
            logger.log(Level.WARNING, "ERROR: ", e);
        } finally {
            if (imputStream != null) {
                try {
                    imputStream.close();
                } catch (IOException e) {
                    logger.log(Level.WARNING, "ERROR: ", e);
                }
            }
        }
        return properties.getProperty(atributopro);
    }

    public Optional<Properties> getPropValues() {
        Properties properties = new Properties();
        String projectDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath().toString();
        String propFileName = projectDirectory + "/serenity.properties";

        try (InputStream inputStream = Files.newInputStream(Paths.get(propFileName))) {
            properties.load(inputStream);
            return Optional.of(properties);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
