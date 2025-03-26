package com.chada.example.data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Standing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private League league;

    @OneToMany(mappedBy = "standing", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TeamStanding> teamStandings;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<TeamStanding> getTeamStandings() {
        return teamStandings;
    }

    public void setTeamStandings(List<TeamStanding> teamStandings) {
        this.teamStandings = teamStandings;
    }
}
