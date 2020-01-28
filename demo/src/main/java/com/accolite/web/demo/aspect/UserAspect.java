package com.accolite.web.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.annotation.AfterThrowing;  

@Aspect
public class UserAspect {


   @AfterThrowing(pointcut = "execution(* com.accolite.web.demo.models*(..))", 
      throwing = "error")
   public void afterThrowingAdvice(JoinPoint jp, Throwable error){
      System.out.println("Method Signature: "  + jp.getSignature());  
      System.out.println("Exception: "+error);  
   }
}