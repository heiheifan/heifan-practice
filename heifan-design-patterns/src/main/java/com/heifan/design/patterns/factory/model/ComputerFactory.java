package com.heifan.design.patterns.factory.model;

/**
 * 工厂类
 *
 * @author HiF
 * @date 2022/6/28 20:34
 */
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equals(type)) {
            return new PC(ram, hdd, cpu);
        }else if ("Server".equals(type)){
            return new Server(ram, hdd, cpu);
        }
      return null;
    }
}
