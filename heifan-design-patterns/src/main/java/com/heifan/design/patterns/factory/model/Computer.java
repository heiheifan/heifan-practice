package com.heifan.design.patterns.factory.model;

/**
 * 抽象类
 * @author HiF
 * @date 2022/6/28 20:21
 */
public abstract class Computer {

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
