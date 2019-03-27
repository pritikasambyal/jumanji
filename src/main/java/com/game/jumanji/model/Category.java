package com.game.jumanji.model;

public enum Category {
    COUNTRY(1),
    SPORTS(2),
    MOVIES(3),
    WORLD(4),
    IT(5),
    GK(6),
    MUSIC(7);


    private int number;

    Category(int number) {
        this.number = number;
    }
}
