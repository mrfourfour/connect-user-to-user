package com.example.connectUserToUser.controller;

import com.example.connectUserToUser.domain.User;
import com.example.connectUserToUser.service.MatchMakerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
public class MatchMakerController {
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerController.class);
    private final MatchMakerService matchMakerService;

    @PostMapping("/api/apply_match")
    public ResponseEntity<User> apply_match(@RequestParam String userId) {

        User user = new User(userId);
        matchMakerService.operateMatchMaker(user);
        return ResponseEntity.ok(user);
    }

}
