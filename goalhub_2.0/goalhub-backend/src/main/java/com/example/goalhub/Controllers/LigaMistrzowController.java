package com.example.goalhub.Controllers;

import com.example.goalhub.Entity.LigaMistrzow;
import com.example.goalhub.Services.LigaMistrzowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liga-mistrzow")
public class LigaMistrzowController {

    @Autowired
    private LigaMistrzowService service;

    @GetMapping
    public List<LigaMistrzow> getTable() {
        return service.getAll();
    }
}
