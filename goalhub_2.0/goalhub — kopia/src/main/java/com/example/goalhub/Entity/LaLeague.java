package com.example.goalhub.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "laliga_2024_2025", schema = "fotmob")
public class LaLeague {
    @Id
    private int pozycja;
    private String druzyna;
    private int mecze;
    private int zwyciestwa;
    private int remisy;
    private int porazki;
    private int bramki_zdobyte;
    private int bramki_stracone;
    private int roznica_bramek;
    private int punkty;
}
