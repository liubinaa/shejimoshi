package com.shejimoshi.creationtype.factory.func;

import com.shejimoshi.creationtype.factory.Milk;

/**
 * 工厂模型
 * @author liubin
 */
public interface Factory {

    /**
     * 工厂必然具有生产产品技能，统一的产品出口
     * @return 产品
     */
    Milk getMilk();
}
