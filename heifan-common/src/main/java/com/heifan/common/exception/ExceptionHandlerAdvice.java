package com.heifan.common.exception;

import com.heifan.common.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * @author HiF
 * @date 2022/6/19 21:48
 */
@Component
@Slf4j
/**
 * 对Controller进行增强的，可以全局捕获spring mvc抛的异常。RestControllerAdvice = ControllerAdvice + ResponseBody
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = {ResponseStatusException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handle(ResponseStatusException ex, HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("response status exception:{}", ex.getMessage());
        if (ex.getStatus().equals(HttpStatus.NOT_FOUND)) {
            return Result.failure("404！");
        }
        if (ex.getStatus().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
            return Result.failure("服务故障,管理人员处理中！");
        }
        return Result.failure("服务开小差,请稍后尝试！");
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result handle(NoHandlerFoundException ex, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("not found exception:{}", ex.getMessage());
        return Result.failure(404, "404！");
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handle(RuntimeException ex, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("runtime exception:{}", ex.getMessage());
        log.error("runtime exception:{}", ex.getCause().toString());
        return Result.failure("服务开小差,请稍后尝试！");
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handle(HttpMessageNotReadableException ex, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("runtime exception:{} {}", "请求参数异常", ex.getMessage());
        return Result.failure("请求参数异常,请稍后尝试！");
    }

    @ExceptionHandler(value = {BizException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handle(BizException ex, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("runtime exception:{}", ex.getMessage());
        return Result.failure(ex.getMessage());
    }

    @ExceptionHandler(value = {ParamException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handle(ParamException ex, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        log.error("runtime exception:{}", ex.getMessage());
        return Result.failure(ex.getMessage());
    }

    /**
     * 统一异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result<?> processException(Exception e, HttpServletResponse response) {
        response.setContentType("application/json; CharSet=UTF-8");
        // 默认返回200状态码
        response.setStatus(HttpStatus.OK.value());
        Result<?> result = null;
        // 处理404
        if (e instanceof NoHandlerFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            result = Result.failure(HttpStatus.NOT_FOUND.value(),
                    "Client Error");
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
            result = Result.failure(HttpStatus.METHOD_NOT_ALLOWED.value(),
                    "Client Error");
        } else {// 其他异常，返回500状态码
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            result = Result.failure(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error");
        }
        return result;
    }
}
