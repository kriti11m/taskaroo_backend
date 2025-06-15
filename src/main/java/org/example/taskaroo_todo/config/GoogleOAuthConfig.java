package org.example.taskaroo_todo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GoogleOAuthConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        InputStream credentialStream = null;

        try {
            // First try to load serviceAccount.json from resources for local development
            ClassPathResource resource = new ClassPathResource("serviceAccount.json");
            credentialStream = resource.getInputStream();
        } catch (IOException e) {
            // If local resource fails, try production paths

            // Try Render's secret location
            File renderSecretFile = new File("/etc/secrets/serviceAccountKey.json");
            if (renderSecretFile.exists()) {
                credentialStream = new FileInputStream(renderSecretFile);
            } else {
                // Try firebase-service-account.json next
                File firebaseServiceAccount = new File("src/main/resources/firebase-service-account.json");
                if (firebaseServiceAccount.exists()) {
                    credentialStream = new FileInputStream(firebaseServiceAccount);
                } else {
                    throw new IOException("No Firebase service account file found");
                }
            }
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(credentialStream))
                .build();

        // Safely handle if Firebase is already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance();
        }
    }
}