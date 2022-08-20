package com.andryanstgkr.desmart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "execution(* com.andryanstgkr.desmart.service..*(..)) ")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get child class of BaseService
        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        //Get intercepted method details
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        logger.error("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

}
