package com.game.jumanji.session;

import com.game.jumanji.model.Player;

import java.util.List;

public class PlayerSession {

    Player currentPlayer;
//    List<Player> playerList;


    public PlayerSession(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
