package com.petso1.petso1.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut expression matching all methods in services package
    @Pointcut("execution(* com.petso1.petso1.services.*.*(..))")
    public void serviceMethods() {}

    // 1. Before Advice
    @Before("serviceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Before Method: {}", joinPoint.getSignature().getName());
    }

    // 2. After Advice
    @After("serviceMethods()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("After Method: {}", joinPoint.getSignature().getName());
    }

    // 3. After Returning Advice
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("After Returning Method: {}", joinPoint.getSignature().getName());
        logger.info("Returned Value: {}", result);
    }

    // 4. After Throwing Advice
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        logger.error("After Throwing Method: {}", joinPoint.getSignature().getName());
        logger.error("Exception: {}", exception.getMessage());
    }

    // 5. Around Advice
    @Around("serviceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Around Method Start: {}", proceedingJoinPoint.getSignature().getName());
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            logger.info("Around Method End: {}", proceedingJoinPoint.getSignature().getName());
        } catch (Throwable throwable) {
            logger.error("Around Method Exception: {}", proceedingJoinPoint.getSignature().getName());
            throw throwable;
        }
        return result;
    }
}
