package com.chada.example.data;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Games {
    private int played;
    private int win;
    private int draw;
    private int lose;

    @Embedded
    private Goals goals;


}
