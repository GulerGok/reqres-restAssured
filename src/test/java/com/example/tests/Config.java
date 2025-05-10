package com.example.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    // Statik blok ile config.properties dosyasını yükle
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties dosyası yüklenemedi.");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getApiKey() {
        return properties.getProperty("apiKey");
    }

    public static int getConnectionTimeout() {
        return Integer.parseInt(properties.getProperty("connectionTimeout"));
    }

    public static int getReadTimeout() {
        return Integer.parseInt(properties.getProperty("readTimeout"));
    }
}
