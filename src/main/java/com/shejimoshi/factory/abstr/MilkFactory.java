package com.shejimoshi.factory.abstr;

import com.shejimoshi.factory.Milk;
import com.shejimoshi.factory.func.TelunsuFactory;
import com.shejimoshi.factory.func.YiliFactory;

/**
 * @author liubin
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getYili() {
        //即用到了抽象工厂，又用到了工厂方法
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }
}
