package com.shejimoshi.factory.simple;

import com.shejimoshi.factory.Milk;
import com.shejimoshi.factory.Telunsu;
import com.shejimoshi.factory.Yili;

/**
 * @author liubin
 */
public class SimpleFactory {
    public Milk getMilk(String name) {
        if ("特仑苏".equals(name)) {
            return new Telunsu();
        } else if ("伊利".equals(name)) {
            return new Yili();
        }
        return null;
    }
}
