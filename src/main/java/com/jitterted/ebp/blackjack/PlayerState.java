package com.jitterted.ebp.blackjack;

//Extracted out the Player state and game rules from Player class.
public enum PlayerState {
    WIN(2),
    LOOSE(0),
    TIE(1);

    int betMultiplicationFactor;
    PlayerState(int belMultiplicationFactor) {
        this.betMultiplicationFactor = belMultiplicationFactor;
    }
}
