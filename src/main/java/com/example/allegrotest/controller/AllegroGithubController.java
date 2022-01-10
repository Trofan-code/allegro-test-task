package com.example.allegrotest.controller;

import com.example.allegrotest.client.ServerGitClient;
import com.example.allegrotest.dto.GithubLanguageRank;
import com.example.allegrotest.dto.GithubRepoEntry;
import com.example.allegrotest.mapper.GithubMapper;
import com.example.allegrotest.model.GithubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Comparator;


import static java.util.Collections.reverseOrder;


@RestController
@RequiredArgsConstructor
public class AllegroGithubController {
    GithubMapper githubMapper = new GithubMapper();
    @Autowired
    private ServerGitClient serverGitClient;


    @GetMapping("/allegro/repositories")
    public Flux<GithubRepoEntry> nameStars() {
        return serverGitClient.getAllGithubRepositories("allegro")
                .map(gitRepo -> githubMapper.toGithubRepoEntry(gitRepo));
    }

    @GetMapping("/allegro/repositories/stars-count")
    public Mono<Integer> countStars() {
        return serverGitClient.getAllGithubRepositories("allegro")
                .map(GithubRepo::getStarsCount)
                .reduce(Integer::sum);
    }

    @GetMapping("/allegro/repositories/popular-languages")
    public Flux<Object> popularLanguages() {
        return serverGitClient.getAllGithubRepositories("allegro")
                .groupBy(GithubRepo::getLanguage)
                .flatMap(group -> Mono.zip(Mono.just(group.key()), group.collectList()))
                .sort(Comparator.comparing(t -> t.getT2().size(), reverseOrder()))
                .map(gitLang -> githubMapper.toGithubLanguageRang2(gitLang));

    }

}

















