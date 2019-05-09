package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Tower {
    int health;
    int width ,height;
    int damage;
    int level;
    Abilties ability;
    int xp;
    Texture image;
    float x, y;

    public Tower(int health, int width, int height, int damage, int level, Abilties ability, int xp, Texture image, float x, float y){
        this.width = width;
        this.height = height;
        this.damage = damage;
        this.level = level;
        this.ability = ability;
        this.xp = xp;
        this.image = image;
        this.x = x;
        this.y = y;
    }
}
