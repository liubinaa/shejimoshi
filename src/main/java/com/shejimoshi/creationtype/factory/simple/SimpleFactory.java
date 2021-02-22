package com.shejimoshi.creationtype.factory.simple;

import com.shejimoshi.creationtype.factory.Milk;
import com.shejimoshi.creationtype.factory.Telunsu;
import com.shejimoshi.creationtype.factory.Yili;

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
