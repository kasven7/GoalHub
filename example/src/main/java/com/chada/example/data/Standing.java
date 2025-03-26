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



}
