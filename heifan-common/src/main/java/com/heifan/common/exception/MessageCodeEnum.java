package com.heifan.common.exception;

/**
 * 异常代码枚举
 * @Author HiF
 * @Date 2022/6/19 21:37
 */
public enum MessageCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功！"),

    /**
     * 未知异常
     */
    UNKNOW_EXCEPTION(301, "未知异常，请联系管理员！"),

    /**
     * 更新操作失败
     */
    NO_UPDATE(302, "系统繁忙，请稍后再试！"),

    /**
     * 请求参数不完整
     */
    PARAM_ERROR(303, "请求参数不完整！"),

    /**
     * 服务器异常
     */
    SERVER_ERROR(304, "服务器开小差，请稍后再试！"),

    /**
     *  未授权
     */
    NOT_LOGIN(305, "未登录系统！"),

    /**
     * 用户其它设备登录中
     */
    USER_OFFLINE(306, "用户其它设备登录中！");

    /**
     * 状态码值
     */
    private int code;
    private String msg;

    MessageCodeEnum(int code, String msg) {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
