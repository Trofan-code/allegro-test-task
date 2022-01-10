package com.example.allegrotest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter


public class GithubRepoEntry {
    private String name;
    @JsonProperty("stargazers_count")
    private int starsCount;
}




