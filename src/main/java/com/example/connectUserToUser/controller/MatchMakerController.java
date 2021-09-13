package com.example.connectUserToUser.controller;

import com.example.connectUserToUser.domain.User;
import com.example.connectUserToUser.service.MatchMakerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MatchMakerController {
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerController.class);
    private final MatchMakerService matchMakerService;


    @GetMapping("/api/apply_match")
    public void apply_match(@RequestBody String userId){
        logger.info("매치 신청");
        User user = new User((userId));
        matchMakerService.operateMatchMaker(user);
    }

}
