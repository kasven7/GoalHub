package com.chada.example.client;

import jakarta.persistence.*;

@Entity
@Table(name = "standingsy")
class Standingsy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer points;
    private Integer goaldiff;
    private String form;

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
