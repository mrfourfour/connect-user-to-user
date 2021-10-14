package com.example.connectUserToUser.configuration;

import com.example.connectUserToUser.domain.MatchMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public MatchMaker matchMaker(){
        return new MatchMaker();
    }
}
