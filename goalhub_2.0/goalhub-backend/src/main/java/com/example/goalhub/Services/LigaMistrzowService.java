package com.example.goalhub.Services;

import com.example.goalhub.Entity.LigaMistrzow;
import com.example.goalhub.Repositories.LigaMistrzowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigaMistrzowService {
    @Autowired
    private LigaMistrzowRepository repository;

    public List<LigaMistrzow> getAll() {
        return repository.findAll();
    }
}