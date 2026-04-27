package com.rpg.rpgcharactersystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // HINT: This class contains AOP rules. a:@Aspect
    // Which annotation marks a class as containing AOP rules?

    // HINT: This class also needs to be a Spring managed bean.
    // Which annotation does that? a:@Component
    @Before("execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[LOG - BEFORE] About to execute: " + methodName);
    }

    // HINT: This method should run BEFORE any method in com.rpg.CharacterService. a:@Before
    // Which advice annotation runs code before the target method?
    // The pointcut expression is: "execution(* com.rpg.CharacterService.*(..))"
    @After("execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[LOG - AFTER] Finished executing: " + methodName);
    }

    // HINT: This method should run AFTER any method in com.rpg.CharacterService a: @After
    // regardless of whether it succeeded or threw an exception.
    // Which advice annotation runs like a finally block?
    // Same pointcut expression as above.
}