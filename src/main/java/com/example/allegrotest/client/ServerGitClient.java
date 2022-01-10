package com.example.allegrotest.client;


import com.example.allegrotest.dto.GithubLanguageRank;
import com.example.allegrotest.model.GithubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.nio.file.AccessDeniedException;
import java.rmi.ServerException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor

public class ServerGitClient {

    private final String baseUrl = "https://api.github.com";
    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .defaultHeader(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<GithubRepo> getAllGithubRepositories(String orgName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/orgs/{org}/repos")
                        .build(orgName))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(() -> new AccessDeniedException("Access denied."))
                )
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(() -> new ServerException("Server not available"))
                )
                .bodyToFlux(GithubRepo.class);
    }


}
