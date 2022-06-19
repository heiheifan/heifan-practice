package com.heifan.common.exception;
/**
 * 统一异常
 * @Author HiF
 * @Date 2022/6/19 21:35
 */
public class BizException extends RuntimeException{

    private static final long serialVersionUID = 5630703876282912325L;

    /**
     * 谁背锅
     */
    private String[] blamedFor;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message = "";

    /**
     * 异常扩展信息
     */
    private String extMessage = "";

    /**
     * 默认的code码
     */
    protected MessageCodeEnum defaultMessageCode = MessageCodeEnum.UNKNOW_EXCEPTION;

    public String[] getBlamedFor() {
        return blamedFor;
    }

    public void setBlamedFor(String[] blamedFor) {
        this.blamedFor = blamedFor;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExtMessage() {
        return extMessage;
    }

    public void setExtMessage(String extMessage) {
        this.extMessage = extMessage;
    }
}
