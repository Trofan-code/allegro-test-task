package com.example.allegrotest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GithubRepo {

    private Long id;
    private String name;
    private int size;
    private String language;
    @JsonProperty("stargazers_count")
    private int starsCount;


}
