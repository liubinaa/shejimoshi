package com.shejimoshi.creationtype.factory.func;

import com.shejimoshi.creationtype.factory.Milk;
import com.shejimoshi.creationtype.factory.Yili;

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
