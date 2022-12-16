package com.project.pokemon.models;

public class PlayersRequest {
    private String name1;
    private String pokemonName1;
    private int pokemonNormalAttack1;
    private int pokemonSpecialAttack1;
    private String name2;
    private String pokemonName2;
    private int pokemonNormalAttack2;
    private int pokemonSpecialAttack2;

    public int getPokemonNormalAttack1() {
        return pokemonNormalAttack1;
    }

    public void setPokemonNormalAttack1(int pokemonNormalAttack1) {
        this.pokemonNormalAttack1 = pokemonNormalAttack1;
    }

    public int getPokemonSpecialAttack1() {
        return pokemonSpecialAttack1;
    }

    public void setPokemonSpecialAttack1(int pokemonSpecialAttack1) {
        this.pokemonSpecialAttack1 = pokemonSpecialAttack1;
    }

    public int getPokemonNormalAttack2() {
        return pokemonNormalAttack2;
    }

    public void setPokemonNormalAttack2(int pokemonNormalAttack2) {
        this.pokemonNormalAttack2 = pokemonNormalAttack2;
    }

    public int getPokemonSpecialAttack2() {
        return pokemonSpecialAttack2;
    }

    public void setPokemonSpecialAttack2(int pokemonSpecialAttack2) {
        this.pokemonSpecialAttack2 = pokemonSpecialAttack2;
    }

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
