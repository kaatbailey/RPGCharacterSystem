package com.rpg.rpgcharactersystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// HINT: This class contains AOP rules. a:@Aspect
// Which annotation marks a class as containing AOP rules?

// HINT: This class also needs to be a Spring managed bean. a: @Component
// Which annotation does that?
@Component
@Aspect
public class PerformanceAspect {

    // HINT: This method needs full control over the method execution. a:@Around
    // It needs to record time BEFORE, call the real method, then record time AFTER.
    // Which advice annotation gives full wrap-around control?
    // Pointcut: "execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))"
    // Note: this advice type uses ProceedingJoinPoint, not just JoinPoint.

    @Around("execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();

        long startTime = System.currentTimeMillis();

        // HINT: This line calls the real method.
        // Without this the real method NEVER executes.
        // What method on ProceedingJoinPoint invokes the real method?  a:proceed
        Object result = pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("[PERF] " + methodName + " took " + (endTime - startTime) + "ms");

        // HINT: If we forget to return this what does every caller get back? a:null
        return result;
    }
}