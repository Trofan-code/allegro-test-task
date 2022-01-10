package com.example.allegrotest.mapper;

import com.example.allegrotest.dto.GitHubLanguageRank;
import com.example.allegrotest.dto.GithubRepoEntry;
import com.example.allegrotest.model.GithubRepo;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

public class GithubMapper {

    public GithubRepoEntry toGithubRepoEntry(GithubRepo githubRepo){
        return GithubRepoEntry.builder()
                .name(githubRepo.getName())
                .starsCount(githubRepo.getStarsCount())
                .build();
    }

    public GitHubLanguageRank toGithubLanguageRang(GithubRepo githubRepo){
        return GitHubLanguageRank.builder()
                .language(githubRepo.getLanguage())
                .size(githubRepo.getSize())
                .build();
    }




    public  List<GithubRepoEntry> toGithubRepoEntry2(List<GithubRepo> allGithubRepositories) {
        return allGithubRepositories.stream()
                .map(x->toGithubRepoEntry(x)
                        ).collect(Collectors.toList());

    }
    public  List<GitHubLanguageRank> toGithubLanguageRang2(List<GithubRepo> allGithubRepositories) {
        return allGithubRepositories.stream()
                .map(x->toGithubLanguageRang(x)
                ).collect(Collectors.toList());

    }


}
