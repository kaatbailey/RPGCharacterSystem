package com.rpg.rpgcharactersystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// HINT: This class is a Spring configuration class.
// Which annotation marks a class as a source of bean definitions?
@Configuration
public class CharacterConfig {

    // HINT: This method produces a Spring managed bean.
    // Which annotation on a method tells Spring to manage the returned object as a bean?
    @Bean
    public CharacterService hero() {
        return new CharacterService("Aldric", 100, 50);
    }
}