package com.hng.profileapi.controller;

import com.hng.profileapi.dto.ProfileResponse;
import com.hng.profileapi.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final UserProfileService profileService;

    public ProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/me")
    public ResponseEntity<ProfileResponse> getProfile(){
        ProfileResponse response = profileService.getProfile();

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }
}
