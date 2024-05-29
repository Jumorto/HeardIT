package com.example.heardit_songmanager_service.service.use_cases;

import com.example.heardit_songmanager_service.domain.GetGoogleCloudStorageResponse;

public interface GoogleCloudStorageServiceUseCase {
    GetGoogleCloudStorageResponse generateSignedUrl(String bucketName, String objectName);
}
