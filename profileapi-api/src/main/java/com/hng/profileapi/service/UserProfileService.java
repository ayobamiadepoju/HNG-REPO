package com.hng.profileapi.service;

import com.hng.profileapi.dto.CatFact;
import com.hng.profileapi.dto.ProfileResponse;
import com.hng.profileapi.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class UserProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileService.class);

    private final RestTemplate restTemplate;


    @Value("${user.email}")
    private String userEmail;

    @Value("${app.user.name}")
    private String userName;

    @Value("${user.stack}")
    private String userStack;

    @Value("${catfacts.api.url}")
    private String catFactsUrl;

    public UserProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProfileResponse getProfile(){
            UserDto user = new UserDto(userName, userEmail, userStack);

            String timestamp = Instant.now().toString();
            logger.debug("Generated timestamp: {}", timestamp);

            String catFact = getCatFact();

            return new ProfileResponse("success", user, timestamp, catFact);

    }

    private String getCatFact() {
        try {
            logger.info("Fetching cat fact from: {}", catFactsUrl);
            CatFact response = restTemplate.getForObject(catFactsUrl, CatFact.class);

            if (response!= null && response.getFact() != null){
                logger.info("Successfully fetched cat fact");
                return response.getFact();
            }
            logger.warn("Cat fact API returned null response");
            return "Cats are amazing creatures!";

        }catch (RestClientException e){
            logger.error("Error fetching cat fact: {}", e.getMessage());
            return "Unable to fetch new fact";
        }
    }
}