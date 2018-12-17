package com.mc.system;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ChenglongChu
 * @description service层切面（未启用）
 * @create 2018/5/28 16:33
 */
//@Aspect
//@Component
public class AopService {
    /**
     * @description service层切点入口
     * @author ChenglongChu
     * @create 2018/5/28 16:33
    **/
    @Pointcut("execution(* com.mc.service.*Service*.*(..))")
    public void serviceAspect() {
    }

    /**
     * @description service层接入前执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:33
    **/
    @Before("serviceAspect()")
    public void before(JoinPoint joinPoint) {
    }

    /**
     * @description controller层环绕进行中执行
     * @param pjp 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:32
     **/
    @Around("serviceAspect()")
    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * @description service层完成后执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:33
    **/
    @After("serviceAspect()")
    public void after(JoinPoint joinPoint) {
    }

    /**
     * @description service层完成后返回时执行
     * @param joinPoint 过程参数
     * @param returnVal 返回参数
     * @author ChenglongChu
     * @create 2018/5/28 16:33
    **/
    @AfterReturning(pointcut = "serviceAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
    }

    /**
     * @description service层抛出异常时执行
     * @param joinPoint 过程参数
     * @param error 异常信息
     * @author ChenglongChu
     * @create 2018/5/28 16:33
    **/
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
    }
}
