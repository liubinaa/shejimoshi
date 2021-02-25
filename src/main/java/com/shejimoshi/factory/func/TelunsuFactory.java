package com.shejimoshi.factory.func;

import com.shejimoshi.factory.Milk;
import com.shejimoshi.factory.Telunsu;

/**
 * 特仑苏工厂
 * @author liubin
 */
public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
