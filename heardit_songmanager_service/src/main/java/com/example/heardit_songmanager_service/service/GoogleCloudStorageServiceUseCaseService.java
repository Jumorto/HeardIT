package com.example.heardit_songmanager_service.service;
import com.example.heardit_songmanager_service.domain.GetGoogleCloudStorageResponse;
import com.example.heardit_songmanager_service.service.use_cases.GoogleCloudStorageServiceUseCase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.BlobInfo;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

@Service
public class GoogleCloudStorageServiceUseCaseService implements GoogleCloudStorageServiceUseCase {

    private final Storage storage;

    public GoogleCloudStorageServiceUseCaseService() throws IOException {
        //   Read the JSON credentials from the environment variable
        String jsonCredentialsPath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        if (jsonCredentialsPath == null) {
            throw new IllegalStateException("GOOGLE_APPLICATION_CREDENTIALS environment variable not set");
        }

        // Load the service account credentials from the JSON file
        GoogleCredentials credentials;
        try (FileInputStream credentialsStream = new FileInputStream(jsonCredentialsPath)) {
            credentials = GoogleCredentials.fromStream(credentialsStream);
        }

        // Instantiate Storage service with the loaded credentials
        this.storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }

    public GetGoogleCloudStorageResponse generateSignedUrl(String bucketName, String objectName) {
        try {
            // URL-encode the object name
            String encodedObjectName = URLEncoder.encode(objectName, "UTF-8");
            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, encodedObjectName).build();
            // Generate signed URL with POST method and 15 minutes expiration
            String signedUrl = storage.signUrl(blobInfo, 15, TimeUnit.MINUTES, Storage.SignUrlOption.httpMethod(HttpMethod.POST)).toString();
            return GetGoogleCloudStorageResponse.builder()
                    .response(signedUrl)
                    .build();
        } catch (UnsupportedEncodingException e) {
            // Handle encoding exception
            e.printStackTrace();
            return null;
        }
    }
}
