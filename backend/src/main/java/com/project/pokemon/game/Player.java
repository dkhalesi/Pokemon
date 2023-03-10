package com.project.pokemon.game;

public class Player {
    private String name;
    private PokemonInGame pokemon;
    private int specialAttackWait;

    public Player(String name, PokemonInGame pokemon) {
        this.name = name;
        this.pokemon = pokemon;
        this.specialAttackWait = 1;
    }

    public Boolean isAlive() {
        return this.pokemon.getHp() > 0;
    }

    public void reset() {
        this.pokemon.resetHP();
        this.specialAttackWait = 0;
    }

    public int normalAttack(Player opponent) {
        int opponentHP = opponent.getPokemon().getHp();
        opponent.getPokemon().setHp(opponentHP - this.pokemon.getNormalAttack());
        this.specialAttackWait = Math.max(this.specialAttackWait - 1, 0);
        return opponent.getPokemon().getHp();
    }

    public int specialAttack(Player opponent) {
        int opponentHP = opponent.getPokemon().getHp();
        opponent.getPokemon().setHp(opponentHP - this.pokemon.getSpecialAttack());
        this.specialAttackWait = 1;
        return opponent.getPokemon().getHp();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonInGame getPokemon() {
        return this.pokemon;
    }

    public void setPokemon(PokemonInGame pokemon) {
        this.pokemon = pokemon;
    }

    public int getSpecialAttackWait() {
        return this.specialAttackWait;
    }

    public void setSpecialAttackWait(int specialAttackWait) {
        this.specialAttackWait = specialAttackWait;
    }
}
