package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchMakerService {

    private final MatchMaker matchMaker;
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerService.class);

    public void operateMatchMaker(User user) throws Exception
    {
        logger.info("풀에 유저 추가");
        matchMaker.applyMatchMakerList(user);

    }
}
// 서비스 단에서는 뭘해야할깡?