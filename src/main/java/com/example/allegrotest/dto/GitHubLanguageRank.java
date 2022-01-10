package com.example.allegrotest.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter



public class GitHubLanguageRank {
    private String language;
    private int size;
}
