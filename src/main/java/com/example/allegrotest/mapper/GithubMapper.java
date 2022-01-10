package com.example.allegrotest.mapper;

import com.example.allegrotest.dto.GithubLanguageRank;
import com.example.allegrotest.dto.GithubRepoEntry;
import com.example.allegrotest.model.GithubRepo;
import reactor.util.function.Tuple2;

import java.util.List;


public class GithubMapper {

    public GithubRepoEntry toGithubRepoEntry(GithubRepo githubRepo) {
        return GithubRepoEntry.builder()
                .name(githubRepo.getName())
                .starsCount(githubRepo.getStarsCount())
                .build();
    }

    public GithubLanguageRank toGithubLanguageRang(GithubRepo githubRepo) {
        return GithubLanguageRank.builder()
                .language(githubRepo.getLanguage())
                .size(githubRepo.getSize())
                .build();
    }

    public Object toGithubLanguageRang2(Tuple2<String, List<GithubRepo>> allData) {
        return GithubLanguageRank.builder()
                .language(allData.getT1())
                .size(allData.getT2().stream()
                        .map(GithubRepo::getSize)
                        .reduce(0, Integer::sum))
                .build();
    }


}
