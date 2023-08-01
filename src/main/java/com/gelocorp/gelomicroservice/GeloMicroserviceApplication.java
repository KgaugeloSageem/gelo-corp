package com.gelocorp.gelomicroservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class GeloMicroserviceApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = GeloMicroserviceApplication.class.getClassLoader();
        String serviceAccountPath = Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile();
        FileInputStream serviceAccountStream = new FileInputStream(serviceAccountPath);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                .build();

        FirebaseApp.initializeApp(options);
        
        SpringApplication.run(GeloMicroserviceApplication.class, args);
    }

}
