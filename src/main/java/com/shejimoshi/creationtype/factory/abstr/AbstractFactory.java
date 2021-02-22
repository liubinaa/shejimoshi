package com.shejimoshi.creationtype.factory.abstr;

import com.shejimoshi.creationtype.factory.Milk;

/**
 * 抽象工厂，是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展，版本升级时对用户体验更好
 * @author liubin
 */
public abstract class AbstractFactory {

    //公共的逻辑，方便统一管理，体现了抽象类的意义

    /**
     * 获得一个伊利品牌的牛奶
     * @return 牛奶
     */
    public abstract Milk getYili();

    /**
     * 获得一个特仑苏品牌的牛奶
     * @return 牛奶
     */
    public abstract Milk getTelunsu();
}
