package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Player player = new Player(20);

    player.playerBets(10);

    player.playerWins();

    player.validateBalance(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Player player = new Player(80);
    player.playerBets(70);

    player.playerTies();

    player.validateBalance(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Player player = new Player(35);

    player.playerBets(30);
    player.playerLoses();

    player.validateBalance(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Player player = new Player(40);

    player.playerBets(15);

    player.validateBalance(25);

  }

  @Test
  public void playerBets100Gets10Bonus() throws Exception {
    Player player = new Player(250);

    player.playerBets(120);

    player.validateBalance(250 - 120 + 10);

  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Player player = new Player(18);
    player.validateBalance(18);
  }

  @Test
  public void playerMultipleDeposits() throws Exception {
    Player player = new Player(18);
    player.playerDeposits(10);
    player.validateBalance(18 + 10);
  }

  @Test
  public void playerNoBetAmount() {
    Player p = new Player();
    assertThat(p.getTotalAmountBet()).isEqualTo(0);
  }

  @Test
  public void playerSingleBetAmount() {
    Player p = new Player();
    p.playerBets(20);
    assertThat(p.getTotalAmountBet()).isEqualTo(20);
  }

  @Test
  public void playerMultipleBetAmount() {
    Player p = new Player();
    p.playerBets(20);
    p.playerBets(40);
    assertThat(p.getTotalAmountBet()).isEqualTo(40 + 20);
  }

  @Test
  public void playerMultipleGames() {
    Player player = new Player();
    player.playerBets(30);
    player.playerLoses();

    player.playerBets(35);
    player.playerWins();

    player.playerBets(10);
    player.playerLoses();

    assertThat(player.getTotalAmountBet()).isEqualTo(30 + 35 + 10);
  }
}