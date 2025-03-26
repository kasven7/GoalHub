package com.chada.example.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class League {
    @Id
    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;

    @OneToOne(mappedBy = "league")
    private Standing standing;


}
