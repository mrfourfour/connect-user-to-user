package com.example.connectUserToUser.controller;

import com.example.connectUserToUser.domain.User;
import com.example.connectUserToUser.service.MatchMakerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MatchMakerController {
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerController.class);
    private final MatchMakerService matchMakerService;

    // 리퀘스트 바디는 정확한 dto가 있어야 사용가능 왜? JO로 변환하기 때문
    @PostMapping("/api/apply_match")
    public ResponseEntity<String> apply_match(@RequestBody User user) {
        logger.info("매치 신청");
        String username = user.getUserId();
        try {
            matchMakerService.operateMatchMaker(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(username);
    }

}
