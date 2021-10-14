package com.example.connectUserToUser.controller;

import com.example.connectUserToUser.ResponseMessage;
import com.example.connectUserToUser.domain.User;
import com.example.connectUserToUser.service.MatchMakerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MatchMakerController {
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerController.class);

    private final MatchMakerService matchMakerService;

    @RequestMapping(method = RequestMethod.POST, value = "/match/request")
    public int matchRequest(@RequestBody User user) throws Exception {
        try {
            matchMakerService.operateMatchMaker(user);
            return HttpStatus.OK.value();
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST.value();
        }

    }

}
