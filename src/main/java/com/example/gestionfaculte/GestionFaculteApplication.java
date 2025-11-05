package com.example.gestionfaculte;

import com.example.gestionfaculte.configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class GestionFaculteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionFaculteApplication.class, args);
    }

}
