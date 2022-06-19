package com.heifan.common.exception;
/**
 * 参数异常
 * @Author HiF
 * @Date 2022/6/19 21:44
 */
public class ParamException extends RuntimeException{

    private static final long serialVersionUID = 4816613341508788996L;

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

    public ParamException() {
        super();
        this.code = defaultMessageCode.getCode();
        this.message = defaultMessageCode.getMsg();
    }

    public ParamException(MessageCodeEnum messageCode) {
        this.code = messageCode.getCode();
        this.message = messageCode.getMsg();
    }

    public ParamException(String extMessage) {
        super();
        this.code = defaultMessageCode.getCode();
        this.message = extMessage;
        setMsg(extMessage);
    }

    public ParamException(String extMessage, Object... args) {
        super();
        this.code = defaultMessageCode.getCode();
        this.message = defaultMessageCode.getMsg();
        setMsg(extMessage, args);
    }

    public ParamException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ParamException(int code, String message, String extMessage) {
        super();
        this.code = code;
        this.message = message;
        this.extMessage = extMessage;
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    /**
     * 填充数据
     *
     * @param extMessage
     */
    private void setMsg(String extMessage) {
        this.extMessage = extMessage;
    }

    /**
     * 多参数绑定
     *
     * @param message，消息体：例如 'ABCD{}F{}H'
     * @param args           绑定数组，例如: E,G 分别替换msg中的{}
     * @return ABCDEFGH
     */
    private void setMsg(String message, Object... args) {
        String[] spi = message.split("\\{\\}");
        StringBuilder resultMsg = new StringBuilder();
        for (int index = 0; index < spi.length; index++) {
            resultMsg.append(spi[index]);
            if (index >= args.length) {
                resultMsg.append("{}");
            } else {
                resultMsg.append(args[index]);
            }
        }
        setMsg(resultMsg.toString());
    }

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
