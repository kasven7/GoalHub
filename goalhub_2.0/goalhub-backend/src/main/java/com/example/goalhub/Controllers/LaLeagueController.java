package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.LaLeague;
import com.example.goalhub.Services.LaLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laliga")
public class LaLeagueController {
    @Autowired
    private LaLeagueService service;

    @GetMapping
    public List<LaLeague> getTable() {
        return service.getAll();
    }
}