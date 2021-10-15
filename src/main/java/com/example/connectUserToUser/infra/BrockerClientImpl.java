package com.example.connectUserToUser.infra;

import com.example.connectUserToUser.domain.MatchUserPair;
import com.example.connectUserToUser.service.BrokerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class BrockerClientImpl implements BrokerClient {
    private final WebClient baseClient;

    @Override
    public void send(MatchUserPair pair) {
        baseClient.post()
                .uri("/match/result") //받을 주소
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(pair) //바디값 지정
                .retrieve()// 문자열
                .bodyToMono(MatchUserPair.class);//클래스에 있는 값 사용
//                .block();  // 비동기
    }
}
