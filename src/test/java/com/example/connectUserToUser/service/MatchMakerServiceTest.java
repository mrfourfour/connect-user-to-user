package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MatchMakerServiceTest {

    @InjectMocks
    private MatchMakerService matchMakerService;

    @Mock
    private MatchMaker matchMaker;

    @Test
    public void 매치메이커_유저_추가() throws Exception {
        //given

        User user = new User("name");
        given(matchMakerService.operateMatchMaker(any())).willReturn(user);

        User returnUser = matchMakerService.operateMatchMaker(user);
        Assertions.assertThat(returnUser)
                .isNotNull()
                .isEqualTo(user);
        matchMakerService.operateMatchMaker(user);
        matchMakerService.operateMatchMaker(user);
        Assertions.assertThatThrownBy(() -> {
            throw new IllegalArgumentException();
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("이미 대기열에 있습니다.");
    }
}