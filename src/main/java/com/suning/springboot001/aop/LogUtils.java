package com.suning.springboot001.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created：Jeffrey
 * date   ：2022/4/25 16:16
 */
@Component
@Aspect
@Slf4j
public class LogUtils {

    @Pointcut(value = "execution(public void com.suning.springboot001.aop.Star.sing(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        log.info("切面前{}");
        pjp.proceed();
        log.info("切面后{}");

    }

}
