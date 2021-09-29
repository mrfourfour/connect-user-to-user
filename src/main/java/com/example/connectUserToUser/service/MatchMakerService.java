package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchMakerService {

    private final MatchMaker matchMaker;
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerService.class);

    public User operateMatchMaker(User user) throws IllegalArgumentException {
        logger.info("풀에 유저 추가");
        return matchMaker.applyMatchMakerList(user);
    }
}
