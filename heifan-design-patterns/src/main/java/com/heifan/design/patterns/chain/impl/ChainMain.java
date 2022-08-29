package com.heifan.design.patterns.chain.impl;

public class ChainMain {
    public static void main(String[] args) {
        int days = 50;
        HeadmanHander headmanHander = new HeadmanHander();
        ChiefHander chiefHander = new ChiefHander();
        GmHander gmHander = new GmHander();
        headmanHander.setNextHandler(chiefHander);
        chiefHander.setNextHandler(gmHander);
        if (headmanHander.handler(days)) {
            System.out.println("您申请的假期已被批准");
        } else {
            System.out.println("最近项目太忙了，暂不批假");
        }
    }
}
