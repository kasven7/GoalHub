package com.chada.example.dto;

import com.chada.example.model.*;

import java.util.List;
import java.util.Map;

// Main response container
public class ApiResponse {
    private String get;
    private Map<String, String> parameters;
    private List<String> errors;
    private int results;
    private Paging paging;
    private List<ResponseItem> response;

    // Getters and setters
    public String getGet() {
        return get;
    }
    public void setGet(String get) {
        this.get = get;
    }
    public Map<String, String> getParameters() {
        return parameters;
    }
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    public int getResults() {
        return results;
    }
    public void setResults(int results) {
        this.results = results;
    }
    public Paging getPaging() {
        return paging;
    }
    public void setPaging(Paging paging) {
        this.paging = paging;
    }
    public List<ResponseItem> getResponse() {
        return response;
    }
    public void setResponse(List<ResponseItem> response) {
        this.response = response;
    }
}

// New classes for the standings information

