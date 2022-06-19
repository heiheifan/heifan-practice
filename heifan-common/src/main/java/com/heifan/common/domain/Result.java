package com.heifan.common.domain;

import java.io.Serializable;

/**
 * 统一返回体
 * @Author HiF
 * @Date 2022/6/19 21:33
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4688674598932085379L;

    private Boolean success;

    private Integer code;

    private String msg;

    private T data;

    private Result(){
    }

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(SysConstant.ResultCode.SUCCESS);
        result.setMsg(null);
        return result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(SysConstant.ResultCode.SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(Integer status, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(status);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(SysConstant.ResultCode.SUCCESS);
        result.setMsg(null);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setCode(SysConstant.ResultCode.SUCCESS);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failure(String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(SysConstant.ResultCode.FAILURE);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> failure(Integer status, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.FALSE);
        result.setCode(status);
        result.setMsg(msg);
        return result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
