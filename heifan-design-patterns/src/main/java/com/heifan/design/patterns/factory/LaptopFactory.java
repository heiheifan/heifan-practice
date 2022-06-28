package com.heifan.design.patterns.factory;

import com.heifan.design.patterns.factory.impl.LenovoLaptop;
import com.heifan.design.patterns.factory.impl.MacLaptop;

public class LaptopFactory {

    public static LaptopI createLapTop(String brand){
        switch (brand){
            case "Lenovo":
                return new LenovoLaptop();
            case "Mac":
                return new MacLaptop();
            default:
                return null;
        }
    }


    public static void main(String[] args) {
        LaptopI mac = LaptopFactory.createLapTop("Mac");
        String brand = mac.brand();
        System.out.println(brand);
    }
}
