package com.project.pokemon.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonListResponse {
    private List<PokemonResponse> results;

    public List<PokemonResponse> getResults() {
        return this.results;
    }

    public void setResults(List<PokemonResponse> results) {
        this.results = results;
    }

}
