package com.chada.example.client;

import com.chada.example.model.Stats;
import jakarta.persistence.*;

@Entity
@Table(name = "standingsy")
public class Standingsy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer points;
    private Integer goaldiff;
    private String form;
    private int played;
    private int win;
    private int draw;
    private int lose;


    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoaldiff() {
        return goaldiff;
    }

    public void setGoaldiff(Integer goaldiff) {
        this.goaldiff = goaldiff;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
