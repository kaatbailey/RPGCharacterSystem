package com.rpg.rpgcharactersystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameRunner implements CommandLineRunner {

    private final CharacterService characterService;

    public GameRunner(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n========== LEVEL UP ==========");
        characterService.levelUp();

        System.out.println("\n========== TAKE DAMAGE ==========");
        characterService.takeDamage(30);

        System.out.println("\n========== HEAL ==========");
        characterService.heal(20);

        System.out.println("\n========== CAST SPELL ==========");
        characterService.castSpell("Fireball", 10);

        System.out.println("\n========== NOT ENOUGH MANA ==========");
        try {
            characterService.castSpell("Meteor", 9999);
        } catch (IllegalStateException e) {
            System.out.println("[GAME] Caught: " + e.getMessage());
        }

        System.out.println("\n========== KILL PLAYER ==========");
        try {
            characterService.takeDamage(9999);
            characterService.heal(10);
        } catch (IllegalStateException e) {
            System.out.println("[GAME] Caught: " + e.getMessage());
        }
    }
}
