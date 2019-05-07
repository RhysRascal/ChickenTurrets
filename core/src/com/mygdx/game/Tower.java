package com.mygdx.game;

public class Tower {
    int health;
    int width ,height;
    int damage;
    int level;
    Abilties ability;
    int xp;

    public Tower(int health, int width, int height, int damage, int level, Abilties ability, int xp) {
        this.health = health;
        this.width = width;
        this.height = height;
        this.damage = damage;
        this.level = level;
        this.ability = ability;
        this.xp = xp;
    }
}
