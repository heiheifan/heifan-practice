package com.heifan.design.patterns.chain;

/**
 * 请假处理器接口
 * @author HiF
 * @date 2022/8/29 15:21
 */
public interface AskForLeaveHander {

    void setNextHandler(AskForLeaveHander nextHandler);

    boolean handler(int days);
}
