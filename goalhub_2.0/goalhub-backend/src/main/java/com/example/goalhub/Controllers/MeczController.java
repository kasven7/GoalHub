package com.example.goalhub.Controllers;
import com.example.goalhub.Entity.Mecze;
import com.example.goalhub.Services.MeczService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MeczController {
    private final MeczService meczService;

    public MeczController(MeczService meczService) {
        this.meczService = meczService;
    }

    @GetMapping()
    public List<Mecze> getAllMatches() {
        return meczService.getAllMatches();
    }

    @GetMapping("/{league}")
    public List<Mecze> getMatches(@PathVariable String league) {
        String normalizedLeague = league.replaceAll("-", " ");
        return meczService.getMatchesByLeague(normalizedLeague);
    }
}
