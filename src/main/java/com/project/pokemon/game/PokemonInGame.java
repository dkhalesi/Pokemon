package com.project.pokemon.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonInGame {
    private String name;
    private int hp;
    private int normalAttack; // TO-DO: change
    private int specialAttack; // TO-DO: change

    public PokemonInGame(String name) {
        this.name = name;
        this.hp = 20;
        this.normalAttack = 1;
        this.specialAttack = 5;
    }

    public void resetHP() {
        this.hp = 20;
    }

    public int getNormalAttack() {
        return normalAttack;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
