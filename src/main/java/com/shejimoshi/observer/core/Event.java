package com.shejimoshi.observer.core;

import lombok.ToString;

import java.lang.reflect.Method;

/**
 * @author liubin
 */
@ToString
public class Event {
    /**
     * 事件源
     */
    private Object source;
    /**
     * 通知目标
     */
    private Object target;
    /**
     * 回调
     */
    private Method callback;
    /**
     * 触发
     */
    private String trigger;
    /**
     * 时间
     */
    private Long time;

    public Object getSource() {
        return source;
    }

    void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Long getTime() {
        return time;
    }

    void setTime(Long time) {
        this.time = time;
    }
}
