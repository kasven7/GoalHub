package com.example.goalhub.Services;

import com.example.goalhub.Entity.PremierLeague;
import com.example.goalhub.Repositories.PremierLeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremierLeagueService {

    @Autowired
    private PremierLeagueRepository repository;

    public List<PremierLeague> getAll() {
        return repository.findAll();
    }
}
