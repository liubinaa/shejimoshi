package com.shejimoshi.creationtype.singleton.register;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式，判断一下name是否被注册了，如果为空，则生成一个，如果不为空，则直接返回
 * IOC单例就是注册式单例
 * @author liubin
 */
public class RegisterMap {
    private RegisterMap () {}
    private static Map<String, Object> register = new ConcurrentHashMap<>();

    public static RegisterMap registerMap(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }
        if (register.get(name) == null) {
            register.put(name, new RegisterMap());
        }
        return (RegisterMap) register.get(name);
    }
}
