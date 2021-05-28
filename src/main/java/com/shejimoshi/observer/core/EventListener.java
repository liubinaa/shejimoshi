package com.shejimoshi.observer.core;

import com.shejimoshi.observer.subject.SubjectEventType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liubin
 */
public class EventListener {

    protected Map<Enum<?>, Event> eventMap = new HashMap<>();

    public void addListener(Enum<?> eventType, Object target, Method callback) {
        //注册事件,用反射调用这个方法
        eventMap.put(eventType, new Event(target, callback));
    }

    protected void trigger(Enum<?> call) {
        if (!this.eventMap.containsKey(call)) {
            return;
        }
        trigger(this.eventMap.get(call).setTrigger(call.toString()));

    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
