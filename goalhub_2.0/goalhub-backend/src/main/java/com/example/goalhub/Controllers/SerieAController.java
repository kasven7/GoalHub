package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.SerieA;
import com.example.goalhub.Services.SerieAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serie-a")
public class SerieAController {

    @Autowired
    private SerieAService service;

    @GetMapping
    public List<SerieA> getTable() {
        return service.getAll();
    }
}
