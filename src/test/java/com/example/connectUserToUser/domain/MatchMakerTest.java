package com.example.connectUserToUser.domain;

import com.example.connectUserToUser.service.MatchMakerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MatchMakerTest {

    @InjectMocks
    private MatchMaker matchMaker;

    private PriorityQueue<String> usersList;
    User user = new User("me");
    User user1 = new User("me2");
    User user2 = new User("me3");


    @Test
    void applyMatchMakerList() {


        System.out.println(usersList);

    }
}