package com.hhx.blog.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.hhx.blog.controller.*.*(..))")
    public void log()
    {

    }
    @Before("log()")
    public void doBefore()
    {
        logger.info("----执行前-----");
    }

    @After("log()")
    public void doAfter()
    {
        logger.info("----执行后----");
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result)
    {
        logger.info("---返回之后------");
    }
}
