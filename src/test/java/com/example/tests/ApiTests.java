package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.HttpClientConfig;
import org.testng.annotations.BeforeClass;

public class ApiTests {

    @BeforeClass
    public void setup() {
        // Base URL'yi Config sınıfından alıyoruz
        RestAssured.baseURI = Config.getBaseUrl();

        // Timeout ayarlarını Config sınıfından alıyoruz ve RestAssured config'ine ekliyoruz
        RestAssured.config = RestAssuredConfig.newConfig()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", Config.getConnectionTimeout())  // Bağlantı timeout'ı
                        .setParam("http.socket.timeout", Config.getReadTimeout()));  // Okuma timeout'ı
    }
}
