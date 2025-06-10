package com.example.goalhub.Services;

import com.example.goalhub.Entity.LaLeague;
import com.example.goalhub.Repositories.LaLeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaLeagueService {
    @Autowired
    private LaLeagueRepository repository;

    public List<LaLeague> getAll() {
        return repository.findAll();
    }
}