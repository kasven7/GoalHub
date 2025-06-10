package com.example.goalhub.Services;

import com.example.goalhub.Entity.SerieA;
import com.example.goalhub.Repositories.SerieARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieAService {
    @Autowired
    private SerieARepository repository;

    public List<SerieA> getAll() {
        return repository.findAll();
    }
}
