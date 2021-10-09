package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchUserPair;

public interface BrokerClient {
    void send(MatchUserPair pair);
}
