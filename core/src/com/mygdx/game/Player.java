package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;

public class Player {

    int money;
    int health;
    Camera camera;

    public Player(int money, int health, Camera camera) {
        this.money = money;
        this.health = health;
        this.camera = camera;
    }
}
