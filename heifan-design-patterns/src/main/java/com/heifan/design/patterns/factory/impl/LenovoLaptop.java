package com.heifan.design.patterns.factory.impl;

import com.heifan.design.patterns.factory.LaptopI;

public class LenovoLaptop implements LaptopI {
    @Override
    public String brand() {
        return "Lenovo";
    }
}
