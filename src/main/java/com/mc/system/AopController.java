package com.mc.system;

import com.alibaba.fastjson.JSON;
import com.mc.constant.CommConstant;
import com.mc.constant.ThreadLocalConstant;
import com.mc.constant.TipsConstant;
import com.mc.enumeration.OptStatusEnum;
import com.mc.mapper.OptRecordMapper;
import com.mc.model.OptRecord;
import com.mc.util.StringUtils;
import com.mc.vo.LocalUserVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author ChenglongChu
 * @description controller层切面
 * @create 2018/05/28 16:31
 */
@Aspect
@Component
public class AopController {
    private final Logger logger = LoggerFactory.getLogger(AopController.class);
    @Autowired
    private OptRecordMapper optRecordMapper;

    /**
     * @description controller层切点入口
     * @author ChenglongChu
     * @create 2018/5/28 16:32
    **/
    @Pointcut("execution(* com.mc.controller.*Controller*.*(..))")
    public void controllerAspect() {
    }

    /**
     * @description controller层接入前执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:32
    **/
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) throws Exception {
    }

    /**
     * @description controller层环绕进行中执行
     * @param pjp 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:32
     **/
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            result = pjp.proceed();
            setOptRecord(request, OptStatusEnum.SUCCESS.getKey());
        } catch (McBusinessException ex) {
            McLog.error(logger, ex, "Controller AOP异常捕获统一处理, 打印错误内容 : ", ex.getMessage());
            String error = ex.getLocalizedMessage();
            String errorCode = error.substring(0, error.indexOf("-"));
            String errorMessage = error.substring(error.indexOf("-") + 1, error.length());
            result = McResult.newFailed(errorCode, errorMessage);
            setOptRecord(request, OptStatusEnum.BIZ_FAIL.getKey(), error);
        } catch (Throwable ex) {
            McLog.error(logger, ex, "Controller AOP异常捕获统一处理, 打印错误内容 : ", ex.getMessage());
            result = McResult.newFailed(TipsConstant.SYSTEM_ERROR.getCode(), TipsConstant.SYSTEM_ERROR.getMessage());
            setOptRecord(request, OptStatusEnum.SYSTEM_FAIL.getKey(), TipsConstant.SYSTEM_ERROR.getFullContent());
        }

        String optUrl = request.getRequestURL().toString();
        String reqParam = preHandle(pjp,request);
        String respParam = postHandle(result);
        McLog.info(logger, "{} 的上送参数是：{}，返回参数是：{}", optUrl, reqParam, respParam);
        return result;
    }

    /**
     * @description controller层完成后执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2018/5/28 16:32
     **/
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {

    }

    /**
     * @description controller层完成后返回时执行
     * @param joinPoint 过程参数
     * @param returnVal 返回参数
     * @author ChenglongChu
     * @create 2018/5/28 16:32
     **/
    @AfterReturning(pointcut = "controllerAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
    }

    /**
     * @description controller层抛出异常时执行
     * @param joinPoint 过程参数
     * @param error 异常信息
     * @author ChenglongChu
     * @create 2018/5/28 16:32
     **/
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
    }

    private void setOptRecord(HttpServletRequest request, String optStatus) {
        setOptRecord(request, optStatus, CommConstant.STRING_EMPTY);
    }

    private void setOptRecord(HttpServletRequest request, String optStatus, String content) {
        OptRecord optRecord = new OptRecord();
        LocalUserVo localUserVo = ThreadLocalConstant.getLocalUser();
        if (null != localUserVo)
            optRecord.setUserId(localUserVo.getUserId());

        optRecord.setOptUrl(StringUtils.formatUri(request.getRequestURI()));
        optRecord.setOptTime(new Date());
        optRecord.setOptStatus(optStatus);
        String ip = getRemoteHost(request);
        optRecord.setOptIp(ip);
        optRecord.setOptContent(content);
        optRecordMapper.insert(optRecord);
    }

    private String preHandle(JoinPoint joinPoint,HttpServletRequest request) {
        String reqParam = "";
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Annotation[] annotations = targetMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            //此处可以改成自定义的注解
            if (annotation.annotationType().equals(RequestMapping.class)) {
                reqParam = JSON.toJSONString(request.getParameterMap());
                break;
            }
        }
        return reqParam;
    }

    private String postHandle(Object retVal) {
        if(null == retVal)
            return "";
        return JSON.toJSONString(retVal);
    }

    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }


}
