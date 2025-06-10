package com.example.goalhub.Services;

import com.example.goalhub.Entity.Ekstraklasa;
import com.example.goalhub.Repositories.EkstraklasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EkstraklasaService {

    @Autowired
    private EkstraklasaRepository repository;

    public List<Ekstraklasa> getAll() {
        return repository.findAll();
    }
}
