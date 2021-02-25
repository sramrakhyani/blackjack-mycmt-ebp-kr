package com.jitterted.ebp.blackjack;
import static org.assertj.core.api.Assertions.*;

public class Player {
    private int playerBalance = 0;
    private int playerBet = 0;

    public Player(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public Player() {
        this.playerBalance = 0;
    }

    public void playerDeposits(int amount) {
        this.playerBalance = playerBalance + amount;
    }

    public void playerBets(int betAmount) {
        this.playerBet = betAmount;
        this.playerBalance = playerBalance - betAmount;
    }

    public void playerWins() {
        this.playerBalance = playerBalance + playerBet * 2;
    }

    public void playerLoses() {
        this.playerBalance = playerBalance + playerBet * 0;
    }

    public void playerTies() {
        this.playerBalance = playerBalance + playerBet * 1;
    }

    public void validateBalance(int i) {
        assertThat(i==playerBalance);
    }
}
