package com.oxygen.studentinfo.aop;

import com.oxygen.studentinfo.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截异常并统一处理
 * @author oxygen
 * @since 2020/04/21
 */
@ControllerAdvice
public class BaseExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(HttpServletResponse response, Exception e) {
        logger.error("出现异常", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new Response(new Date().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "出现错误", null);
    }
}
