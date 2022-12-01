package com.example.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("within(com.example.controller.*)")
    public void callMethod(JoinPoint joinPoint){
        System.out.println("Đang thực hiện phương thức " + joinPoint.getSignature().getName());
    }

    @Before("callMethod(joinPoint)")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("Bắt đầu thực hiện phương thức " + joinPoint.getSignature().getName());
    }

    @After("callMethod(joinPoint)")
    public void afterCallMethod(JoinPoint joinPoint){
        System.out.println("Kết thức thực hiện phương thức " + joinPoint.getSignature().getName());
    }
}
