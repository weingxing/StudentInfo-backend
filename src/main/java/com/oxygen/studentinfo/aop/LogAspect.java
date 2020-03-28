package com.oxygen.studentinfo.aop;


import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.oxygen.studentinfo.dto.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 切面处理类，Controller日志记录
 * @author oxygen
 * @since 2020/03/28
 */
@Aspect
@Component
public class LogAspect {
    private final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.oxygen.studentinfo.controller..*.*(..))")
    public void controllerMethod() {
    }

    /**
     * 方法执行前
     * @param joinPoint
     * @throws Exception
     */
    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder requestLog = new StringBuilder();
        Signature signature = joinPoint.getSignature();
        requestLog.append(((MethodSignature) signature).getMethod())
                .append("\t")
                .append("请求信息：").append("URL = {").append(request.getRequestURI())
                .append("},\t")
                .append("请求方式 = {").append(request.getMethod())
                .append("},\t")
                .append("请求IP = {").append(request.getRemoteAddr())
                .append("},\t")
                .append("类方法 = {").append(signature.getDeclaringTypeName())
                .append(".")
                .append(signature.getName())
                .append("},\t");

        // 处理请求参数
        String[] paramNames = ((MethodSignature) signature).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        int paramLength = null == paramNames ? 0 : paramNames.length;
        if (paramLength == 0) {
            requestLog.append("请求参数 = {} ");
        } else {
            requestLog.append("请求参数 = [");
            for (int i = 0; i < paramLength - 1; i++) {
                requestLog.append(paramNames[i])
                        .append("=")
                        .append(JSONObject.toJSONString(paramValues[i]))
                        .append(",");
            }
            requestLog.append(paramNames[paramLength - 1])
                    .append("=")
                    .append(JSONObject.toJSONString(paramValues[paramLength - 1]))
                    .append("]");
        }

        log.info(requestLog.toString());
    }


    /**
     * 方法执行后
     * @param response
     * @throws Exception
     */
    @AfterReturning(returning = "response", pointcut = "controllerMethod()")
    public void logResultInfo(Response response) throws Exception {
        log.info("请求结果：" + response.getTime()+ "\t" + response.getMessage());
    }
}
