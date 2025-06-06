package com.restapi.allannotations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// Pointcut: intercept all methods in the service package. Explanaiton of expression language syntax in notes. 
	//* return type - package name - any class * -  any method of that class  * - (..) - any method arguments.  
    @Pointcut("execution(* com.restapi.allannotations.controller.*.*(..))")
    public void controllerMethods() {}

    // Advice: run before method execution
    @Before("controllerMethods()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("➡️ Calling method: " + joinPoint.getSignature().getName());
    }

    // Advice: run after method returns successfully
    @AfterReturning(pointcut = "controllerMethods()", returning = "result" )
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        System.out.println("✅ Method returned: " + result);
    }

    // Advice: run after method throws exception
    @AfterThrowing(pointcut = "controllerMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("❌ Method threw an exception: " + ex.getMessage());
    }

}
