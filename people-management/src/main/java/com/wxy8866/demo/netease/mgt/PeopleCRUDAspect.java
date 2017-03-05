package com.wxy8866.demo.netease.mgt;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PeopleCRUDAspect
{

    @AfterReturning("execution(* com.wxy8866.demo.netease.mgt.*.*(..))")
    public void logAfterReturning(JoinPoint jp)
    {
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.print("Called: " + className + ", Method: " + methodName + ", Params：");
        for (Object obj : jp.getArgs())
        {
            System.out.print(obj.toString());
        }
        System.out.println();
    }

    @AfterThrowing(pointcut = "execution(* com.wxy8866.demo.netease.mgt.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint jp, Exception exception)
    {
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        System.out.print("!!!Exception throwed !!!"+ "Exception: " + exception.getMessage() +", Called: " + className + ", Method: " + methodName + ", Params: ");
        for (Object obj : jp.getArgs())
        {
            System.out.print(obj.toString());
        }
        System.out.println();
    }
}