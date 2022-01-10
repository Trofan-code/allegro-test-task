package com.example.allegrotest.client;


import com.example.allegrotest.dto.GitHubLanguageRank;
import com.example.allegrotest.model.GithubRepo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.nio.file.AccessDeniedException;
import java.rmi.ServerException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

//listowanie repozytoriów (nazwa i liczba gwiazdek),
// zwracanie sumy gwiazdek we wszystkich repozytoriach,
// (propozycja) listowanie najpopularniejszych języków programowania (nazwa, liczba bajtów
//kodu)
// /orgs/{org}/repos

@RequiredArgsConstructor

public class ServerGitClient {

    private final String baseUrl = "https://api.github.com";
    private WebClient webClient;

    @PostConstruct
    public void  init(){
        webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .defaultHeader(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<GithubRepo> getAllGithubRepositories(String orgName){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/orgs/{org}/repos")
                .build(orgName))
                //.uri(" /orgs/{org}/repos","allegro")
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(() -> new AccessDeniedException("Access denied."))
                )
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(() -> new ServerException("Server not available"))
                )
               // .flatMap(clientResponse -> clientResponse.bodyToFlux(GithubRepo.class)).block();
                .bodyToFlux(GithubRepo.class);
    }
    public Flux<GitHubLanguageRank> getLanguageRanking(String owner, String repo){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/repos/{owner}/{repo}/languages")
                        .build(owner,repo))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(() -> new AccessDeniedException("Access denied."))
                )
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(() -> new ServerException("Server not available"))
                )
                .bodyToFlux(GitHubLanguageRank.class);
    }






}
