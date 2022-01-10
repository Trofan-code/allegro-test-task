package com.example.allegrotest.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter


public class GithubLanguageRank {
    private String language;
    private int size;
}
