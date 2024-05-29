//package com.example.heardit_songmanager_service.controller;
//
//import com.example.heardit_songmanager_service.domain.GetGoogleCloudStorageResponse;
//import com.example.heardit_songmanager_service.service.use_cases.GoogleCloudStorageServiceUseCase;
//import lombok.AllArgsConstructor;
//import lombok.Generated;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Generated
//@RestController
//@RequestMapping("/api/manage")
//@AllArgsConstructor
//@CrossOrigin(origins = {"http://localhost:3000", "https://heardit-frontend-slsv6nh5ga-ez.a.run.app"})
//public class SignedUrlController {
//
//    @Autowired
//    private GoogleCloudStorageServiceUseCase googleCloudStorageServiceUseCase;
//
//    @GetMapping("/generateSignedUrl")
//    public ResponseEntity<GetGoogleCloudStorageResponse> generateSignedUrl(@RequestParam(value = "bucketName", required = false) String bucketName,
//                                                                           @RequestParam(value = "objectName", required = false) String objectName) {
//        GetGoogleCloudStorageResponse response = googleCloudStorageServiceUseCase.generateSignedUrl(bucketName, objectName);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//}
