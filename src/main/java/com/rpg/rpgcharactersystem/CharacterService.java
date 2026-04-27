package com.rpg.rpgcharactersystem;

public class CharacterService {

    private String name;
    private int health;
    private int maxHealth;
    private int level;
    private int mana;

    public CharacterService(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.level = 1;
    }

    public void levelUp() {
        level++;
        maxHealth += 20;
        health = maxHealth;
        mana += 10;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " took " + amount + " damage. Health: " + health);
        if (health <= 0) {
            die();
        }
    }

    public void heal(int amount) {
        if (health <= 0) {
            throw new IllegalStateException(name + " is dead and cannot be healed!");
        }
        health = Math.min(health + amount, maxHealth);
        System.out.println(name + " healed " + amount + " HP. Health: " + health);
    }

    public String castSpell(String spellName, int manaCost) {
        if (manaCost > mana) {
            throw new IllegalStateException(name + " does not have enough mana to cast " + spellName);
        }
        mana -= manaCost;
        System.out.println(name + " cast " + spellName + "! Mana remaining: " + mana);
        return spellName + " cast successfully";
    }

    private void die() {
        System.out.println(name + " has died!");
    }

    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getLevel() { return level; }
    public int getMana() { return mana; }
}