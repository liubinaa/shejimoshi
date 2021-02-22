package com.shejimoshi.creationtype.factory.func;

import com.shejimoshi.creationtype.factory.Milk;
import com.shejimoshi.creationtype.factory.Telunsu;

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
