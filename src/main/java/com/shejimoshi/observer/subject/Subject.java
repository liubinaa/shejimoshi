package com.shejimoshi.observer.subject;

import com.shejimoshi.observer.core.EventListener;

/**
 * @author liubin
 */
public class Subject extends EventListener {

    /**
     * 通常的话，采用动态代理来实现监控，避免了代码侵入
     */
    public void add() {
        System.out.println("调用添加的方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove() {
        System.out.println("调用移除的方法");
        trigger(SubjectEventType.ON_REMOVE);
    }
}
