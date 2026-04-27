package com.rpg.rpgcharactersystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// HINT: This class contains AOP rules.
// Which annotation marks a class as containing AOP rules?

// HINT: This class also needs to be a Spring managed bean.
// Which annotation does that?
@Component
@Aspect
public class AuditAspect {
   @AfterReturning(
           pointcut = "execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))",
           returning = "returnValue"
   )

    public void auditSuccessfulOperation(JoinPoint joinPoint, Object returnValue) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AUDIT - SUCCESS] " + methodName + " returned: " + returnValue);
    }

    // HINT: This method runs ONLY when a method returns successfully.
    // It can read the return value via the 'returning' attribute.
    // Which advice annotation is that? a: @AfterReturning
    // Pointcut: "execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))"
    // The annotation should look like: @SomeAnnotation(pointcut="...", returning="returnValue")

    @AfterThrowing(
            pointcut = "execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))",
            throwing="exception"
    )
    public void auditFailedOperation(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AUDIT - FAILED] " + methodName + " threw: "
                + exception.getClass().getSimpleName() + " - " + exception.getMessage());
    }

    // HINT: This method runs ONLY when a method throws an exception. a:@AfterThrowing
    // It can read the exception via the 'throwing' attribute.
    // Which advice annotation is that?
    // Pointcut: "execution(* com.rpg.rpgcharactersystem.CharacterService.*(..))"
    // The annotation should look like: @SomeAnnotation(pointcut="...", throwing="exception")
}