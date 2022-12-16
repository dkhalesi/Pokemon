package com.project.pokemon.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String name;
    private String height;
    private String weight;

    private int hp;
    private int normalAttack; // TO-DO: change
    private int specialAttack; // TO-DO: change

    public Pokemon() {
        this.hp = 20;
        this.normalAttack = 1;
        this.specialAttack = 5;
    }

    public Pokemon(String name, String height, String weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
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

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
