package com.project.pokemon.models;

public class PlayersRequest {
    private String name1;
    private String pokemonName1;
    private String name2;
    private String pokemonName2;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPokemonName1() {
        return pokemonName1;
    }

    public void setPokemonName1(String pokemonName1) {
        this.pokemonName1 = pokemonName1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getPokemonName2() {
        return pokemonName2;
    }

    public void setPokemonName2(String pokemonName2) {
        this.pokemonName2 = pokemonName2;
    }
}
