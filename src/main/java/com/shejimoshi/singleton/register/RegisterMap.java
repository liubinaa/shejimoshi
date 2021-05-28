package com.shejimoshi.singleton.register;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式，判断一下name是否被注册了，如果为空，则生成一个，如果不为空，则直接返回
 * IOC单例就是注册式单例
 *
 * @author liubin
 */
public class RegisterMap {
    private RegisterMap() {
    }

    private static Map<String, Object> register = new ConcurrentHashMap<>();

    public static Object registerMap(String name) {
        if (register.containsKey(name)) {
            return register.get(name);
        } else {
            try {
                Class<?> o = Class.forName(name);
                Constructor<?> c = o.getDeclaredConstructor();
                c.setAccessible(true);
                return register.put(name, c.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
