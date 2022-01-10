package com.example.allegrotest.controller;

import com.example.allegrotest.client.ServerGitClient;
import com.example.allegrotest.dto.GitHubLanguageRank;
import com.example.allegrotest.dto.GithubRepoEntry;
import com.example.allegrotest.mapper.GithubMapper;
import com.example.allegrotest.model.GithubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static reactor.core.publisher.Flux.fromStream;

@RestController
@RequiredArgsConstructor
public class AllegroGithubController {
    GithubMapper githubMapper = new GithubMapper();
    @Autowired
    private ServerGitClient serverGitClient;


    @GetMapping("name-stars")
    public Flux<GithubRepoEntry> nameStars() {
        return  serverGitClient.getAllGithubRepositories("allegro")
                .map(gitRepo -> githubMapper.toGithubRepoEntry(gitRepo))
                .log();
        //return serverGitClient.getAllGithubRepositories("allegro");
    }

    @GetMapping("stars")
    public Mono<Integer> countStars() {
        return serverGitClient.getAllGithubRepositories("allegro")
                .map(GithubRepo::getStarsCount)
                .reduce(Integer::sum);
    }
    @GetMapping("test3")
    public Flux<GitHubLanguageRank> test3() {
        return serverGitClient.getAllGithubRepositories("allegro")
                .map(git->githubMapper.toGithubLanguageRang(git))
                .log();
        //Map<Long, String> map =
        //    list.stream()
        //        .sorted(Comparator.comparing(Building::getName))
        //        .collect(Collectors.toMap(Building::getId,Building::getName));
    }


    @GetMapping("rank")
    public Flux<GitHubLanguageRank> languageRank(){
        return serverGitClient.getLanguageRanking("allegro","ralph");
    }
    @GetMapping("getAll")
    public Flux<GithubRepo> getAll(){
        return serverGitClient.getAllGithubRepositories("allegro");
    }


}

















