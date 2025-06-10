package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.BundesLeague;
import com.example.goalhub.Services.BundesLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bundesliga")
public class BundesLeagueController {
    @Autowired
    private BundesLeagueService service;

    @GetMapping
    public List<BundesLeague> getTable() {
        return service.getAll();
    }
}