package com.project.pokemon.game;

import java.util.List;
import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private int playerTurn;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        Random random = new Random();
        this.playerTurn = random.nextInt(2) + 1;
    }

    public void startFight(List<String> logs) {
        while (this.player1.isAlive() && this.player2.isAlive()) {
            if (this.playerTurn == 1) {
                String attackType = attack(this.player1, this.player2);
                this.playerTurn = 2;
                logs.add(describeAttack(player1, player2, attackType));
            } else {
                String attackType = attack(this.player2, this.player1);
                this.playerTurn = 1;
                logs.add(describeAttack(player2, player1, attackType));
            }
        }
    }

    public String attack(Player attacker, Player opponent) {
        if (attacker.getSpecialAttackWait() == 0) {
            attacker.specialAttack(opponent);
            return "Special Attack";
        } else {
            attacker.normalAttack(opponent);
            return "Normal Attack";
        }
    }

    private String describeAttack(Player attacker, Player opponent, String attackType) {
        return attacker.getName() + " attacks " + opponent.getName() + "'s pokemon with "
                + attacker.getPokemon().getName() + "'s "
                + attackType + " leaving " + opponent.getPokemon().getName() + " with "
                + Math.max(opponent.getPokemon().getHp(), 0)
                + "HP";
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
