package com.xyy.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.xyy.aop")
@Aspect
public class MyAop {

    //配置切面
    @Pointcut("execution(* com.xyy.service.UserService.*(..))")
    public void cut() {
        System.out.println("定义好的切面");
    }

    @Before("cut()")
    public void begin() {
        System.out.println("前置通知");
    }

    @After("cut()")
    public void close() {
        System.out.println("后置通知");
    }
}
