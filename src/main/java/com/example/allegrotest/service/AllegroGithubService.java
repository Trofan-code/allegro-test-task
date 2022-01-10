package com.example.allegrotest.service;


import com.example.allegrotest.client.ServerGitClient;
import com.example.allegrotest.dto.GithubRepoEntry;
import com.example.allegrotest.mapper.GithubMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

//3 metoda
//1-getall
//2wyzow repozit + posczitat wsie zwiezdy
//poze
@Slf4j
@Service
@RequiredArgsConstructor
public class AllegroGithubService {

 /*   private final ServerGitClient serverGitClient;
    private GithubMapper githubMapper = new GithubMapper();

    public List<GithubRepoEntry> getAll(String orgName){
      //  log.debug("All git repo names + stars");
        return githubMapper.toGithubRepoEntry(serverGitClient.getAllGithubRepositories(orgName));


    }*/

}
