package com.example.connectUserToUser.infra;

import com.example.connectUserToUser.domain.MatchUserPair;
import com.example.connectUserToUser.service.BrokerClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BrockerClientImpl implements BrokerClient {
    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @Override
    public void send(MatchUserPair pair) {
        webClient.post()
                .uri("/api/getMatchUser") //받을 주소
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(pair) //바디값 지정
                .retrieve()// 문자열
                .bodyToMono(MatchUserPair.class);//클래스에 있는 값 사용
//                .block();  // 비동기
    }
}
