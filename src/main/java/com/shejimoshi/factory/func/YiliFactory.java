package com.shejimoshi.factory.func;

import com.shejimoshi.factory.Milk;
import com.shejimoshi.factory.Yili;

/**
 * 伊利工厂
 * @author liubin
 */
public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
