package com.example.goalhub.Services;

import com.example.goalhub.Entity.Mecze;
import com.example.goalhub.Repositories.MeczRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeczService {
    private final MeczRepository meczRepository;

    public MeczService(MeczRepository meczRepository) {
        this.meczRepository = meczRepository;
    }

    public List<Mecze> getMatchesByLeague(String league) {
        return meczRepository.findByLeagueIgnoreCaseOrderByMatchDateAsc(league);
    }

    public List<Mecze> getAllMatches(){return meczRepository.findAll();}


}
