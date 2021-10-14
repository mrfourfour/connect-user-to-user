package com.example.connectUserToUser.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(of = "userId") // 두개의 인스턴스에 대한 돟등성 비교를 위한 에노테이션
public class User implements Comparable<User> {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }
    public User(){

    }


    @Override
    public int compareTo(User o) {
        return userId.compareTo(o.userId);
    }
}
