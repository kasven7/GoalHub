package com.chada.example.model;

import com.chada.example.api.Coverage;

class Season {
    private int year;
    private String start;
    private String end;
    private boolean current;
    private Coverage coverage;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }
}
