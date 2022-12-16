package com.project.pokemon.game;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private Player player1;
    private Player player2;
    private int player1Wins;
    private int player2Wins;
    public List<String> logs;

    public Tournament(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Wins = 0;
        this.player2Wins = 0;
        this.logs = new ArrayList<>();
    }

    public List<String> simulateTournament() {
        while (this.player1Wins < 2 && this.player1Wins < 2) {
            Game game = this.createGame(player1, player2);
            game.startFight(logs);

            if (this.player1.isAlive()) {
                this.player1Wins++;
                logs.add(roundWinner(player1));
            } else {
                this.player2Wins++;
                logs.add(roundWinner(player2));
            }
        }

        if (this.player1Wins == 2) {
            logs.add(tournamentWinner(player1));
        } else {
            logs.add(tournamentWinner(player2));
        }

        return logs;
    }

    public Game createGame(Player player1, Player player2) {
        player1.reset();
        player2.reset();
        return new Game(player1, player2);
    }

    private String roundWinner(Player player) {
        return player.getName() + " is the winner of Round " + (this.player1Wins + this.player2Wins);
    }

    private String tournamentWinner(Player player) {
        return player.getName() + " is the winner of the Tournament!";
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public void setPlayer1Wins(int player1Wins) {
        this.player1Wins = player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public void setPlayer2Wins(int player2Wins) {
        this.player2Wins = player2Wins;
    }

}
