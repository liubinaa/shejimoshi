package com.shejimoshi.observer.subject;

import com.shejimoshi.observer.core.Event;

/**
 * @author liubin
 */
public class Observer {
    public void advice (Event event) {
        System.out.println("==========触发事件，打印日志===========");
        System.out.println(event);
    }
}
