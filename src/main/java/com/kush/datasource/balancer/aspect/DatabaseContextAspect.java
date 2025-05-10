package com.kush.datasource.balancer.aspect;

import com.kush.datasource.balancer.config.DatabaseContextHolder;
import com.kush.datasource.balancer.config.DatabaseType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Order(1)
public class DatabaseContextAspect {

    @Around("@annotation(transactional)")
    public Object switchDataSource(ProceedingJoinPoint joinPoint, Transactional transactional) throws Throwable {
        DatabaseContextHolder.set(transactional.readOnly() ? DatabaseType.READER : DatabaseType.WRITER);
        try {
            return joinPoint.proceed();
        } finally {
            DatabaseContextHolder.clear();
        }
    }
}
