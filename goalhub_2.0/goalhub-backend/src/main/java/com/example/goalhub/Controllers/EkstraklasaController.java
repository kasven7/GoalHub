package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.Ekstraklasa;
import com.example.goalhub.Services.EkstraklasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ekstraklasa")
public class EkstraklasaController {
    @Autowired
    private EkstraklasaService service;

    @GetMapping
    public List<Ekstraklasa> getTable() {
        return service.getAll();
    }
}