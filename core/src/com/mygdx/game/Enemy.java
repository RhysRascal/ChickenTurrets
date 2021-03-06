package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Abilties;

public class Enemy {

    float x;
    float y;
    int health;
    int width, height;
    int damage;
    int level;
    float movespeed;
    Texture sprite;
    Enum immunities;
    Enum weaknesses;

    public Enemy(int health, int width, int height, int damage, int level, float movespeed, Texture sprite,
    float x, float y) {
        this.health = health;
        this.width = width;
        this.height = height;
        this.damage = damage;
        this.level = level;
        this.movespeed = movespeed;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }
}
