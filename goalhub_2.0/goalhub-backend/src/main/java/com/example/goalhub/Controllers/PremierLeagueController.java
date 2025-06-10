package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.PremierLeague;
import com.example.goalhub.Services.PremierLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premier-league")
public class PremierLeagueController {

    @Autowired
    private PremierLeagueService service;

    @GetMapping
    public List<PremierLeague> getTable() {
        return service.getAll();
    }
}
