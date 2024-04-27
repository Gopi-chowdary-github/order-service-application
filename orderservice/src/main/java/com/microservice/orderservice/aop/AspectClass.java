package com.microservice.orderservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AspectClass {

    @Before(value = "execution(* com.microservice.orderservice.contorller.CustomerController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Requestiong to" + joinPoint.getSignature() +" Started at " + new Date());
    }
    @After(value = "execution(* com.microservice.orderservice.contorller.CustomerController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("Requestiong to" + joinPoint.getSignature() +" ended at " + new Date());
    }
}
