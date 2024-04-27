package com.microservice.orderservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class AnnotationAspect {

    @Before("@annotation(TransactionalAnn)")
    public  void pointCutForCustomAnnotation(JoinPoint joinPoint){
        Annotation[] tar = joinPoint.getClass().getAnnotations();
         System.out.println(tar.toString());
            System.out.println(" Aspect method called" + joinPoint.getSignature());
    };
}
