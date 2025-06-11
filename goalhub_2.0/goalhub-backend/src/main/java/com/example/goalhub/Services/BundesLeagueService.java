package com.example.goalhub.Services;

import com.example.goalhub.Entity.BundesLeague;
import com.example.goalhub.Repositories.BundesLeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundesLeagueService {
    @Autowired
    private BundesLeagueRepository repository;

    public List<BundesLeague> getAll() {
        return repository.findAll();
    }
}