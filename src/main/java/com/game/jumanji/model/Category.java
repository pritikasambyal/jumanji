package com.game.jumanji.model;

public enum Category {
    COUNTRY(1),
    MUSIC(2),
    MOVIES(3),
    WORLD(4),
    IT(5),
    GK(6);


    private int number;

    Category(int number) {
        this.number = number;
    }
}
