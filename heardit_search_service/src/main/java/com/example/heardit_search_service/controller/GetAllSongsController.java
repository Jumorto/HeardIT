package com.example.heardit_search_service.controller;

import com.example.heardit_search_service.domain.GetAllSongsRequest;
import com.example.heardit_search_service.domain.GetAllSongsResponse;
import com.example.heardit_search_service.service.use_cases.GetAllSongsUseCase;
import lombok.AllArgsConstructor;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Generated
@RestController
@CrossOrigin(origins = "http://localhost:3000" )
@AllArgsConstructor
@RequestMapping("/api/search")
public class GetAllSongsController {
    private final GetAllSongsUseCase getAllSongsUseCase;

    @GetMapping() //http://localhost:8081/api/search?nametrack=nine
    public ResponseEntity<GetAllSongsResponse> getAllSongs(@RequestParam(value = "nametrack", required = false) String nametrack){
        GetAllSongsRequest request = GetAllSongsRequest.builder().nametrack(nametrack).build();
        GetAllSongsResponse response = getAllSongsUseCase.getAllSongs(request);
        return ResponseEntity.ok(response);
    }
}
