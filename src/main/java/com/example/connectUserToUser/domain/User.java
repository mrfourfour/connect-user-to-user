package com.example.connectUserToUser.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(of = "userId") // 두개의 인스턴스에 대한 돟등성 비교를 위한 에노테이션
@RequiredArgsConstructor
public class User {
    private final String userId;
}
