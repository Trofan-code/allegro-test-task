package com.example.allegrotest.configuration;

import com.example.allegrotest.client.ServerGitClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class GenericConfiguration {
    @Bean
    public ServerGitClient serverWebClient() {
        return new ServerGitClient();
    }
}
