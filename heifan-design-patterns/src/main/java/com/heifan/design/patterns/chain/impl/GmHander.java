package com.heifan.design.patterns.chain.impl;

import com.heifan.design.patterns.chain.AskForLeaveHander;

/**
 * 总经理处理器
 * @author HiF
 * @date 2022/8/29 15:23
 */
public class GmHander implements AskForLeaveHander {

    private AskForLeaveHander nextHandler;

    @Override
    public void setNextHandler(AskForLeaveHander nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int days) {
        if (days <= 60){
            System.out.println("总经理成功批复了！");
            return true;
        }
        System.out.println(String.format("单次最多只能请60天假！",days));
        return nextHandler.handler(days);
    }
}
