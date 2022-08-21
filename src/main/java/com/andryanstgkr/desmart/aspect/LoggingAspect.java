package com.andryanstgkr.desmart.aspect;

import com.andryanstgkr.desmart.model.AuditLog;
import com.andryanstgkr.desmart.repository.AuditLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuditLogRepository auditLogRepository;

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


    @Before(value = "execution(* com.andryanstgkr.desmart.service..*(..)) ")
    public void profileAllMethods(JoinPoint joinPoint) throws Throwable
    {
        String error = "Error while accessing page detail";
        String errorMessage = error.substring(0,15);
        logger.error("Audit Logs here");
        AuditLog auditLog = new AuditLog();
        auditLog.setActionType(joinPoint.getSignature().getName());
        auditLog.setStatus("E");
        auditLog.setError(errorMessage);
        auditLogRepository.save(auditLog);
    }
}
