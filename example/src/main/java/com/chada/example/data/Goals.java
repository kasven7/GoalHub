package com.chada.example.data;

import jakarta.persistence.Embeddable;

@Embeddable
public class Goals {
    private int goalsFor;
    private int goalsAgainst;

}
