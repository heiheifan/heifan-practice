package com.heifan.design.patterns.chain.impl;

import com.heifan.design.patterns.chain.AskForLeaveHander;

/**
 * 组长处理器
 * @author HiF
 * @date 2022/8/29 15:23
 */
public class HeadmanHander implements AskForLeaveHander {

    private AskForLeaveHander nextHandler;

    @Override
    public void setNextHandler(AskForLeaveHander nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handler(int days) {
        if (days <= 3){
            System.out.println("组长成功批复了！");
            return true;
        }
        System.out.println(String.format("%d 天假期超出组长权限,请总监批复",days));
        return nextHandler.handler(days);
    }
}
