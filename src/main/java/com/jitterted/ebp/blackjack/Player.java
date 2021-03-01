package com.jitterted.ebp.blackjack;
import static org.assertj.core.api.Assertions.*;

public class Player {
    private int playerBalance = 0;
    private int playerBet = 0;
    private int totalPlayerBet = 0;

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
        this.totalPlayerBet += betAmount;
        this.playerBalance = playerBalance - betAmount + getBonusAmount(betAmount);

    }

    private int getBonusAmount(int betAmount) {
        if(betAmount >= 100)
           return 10;
        return 0;
    }

    private void updatePlayerBalanceByState(PlayerState plState) {
        this.playerBalance += plState.betMultiplicationFactor * playerBet;
    }

    public void playerWins() {
        updatePlayerBalanceByState(PlayerState.WIN);
    }

    public void playerLoses() {
        updatePlayerBalanceByState(PlayerState.LOOSE);
    }

    public void playerTies() {
        updatePlayerBalanceByState(PlayerState.TIE);
    }

    public void validateBalance(int i) {
        assertThat(playerBalance).isEqualTo(i);
    }

    public int getTotalAmountBet() {
        return totalPlayerBet;
    }
}
