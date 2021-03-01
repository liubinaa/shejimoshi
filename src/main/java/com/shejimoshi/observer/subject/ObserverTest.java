package com.shejimoshi.observer.subject;

import com.shejimoshi.observer.core.Event;

import java.lang.reflect.Method;

/**
 * @author liubin
 */
public class ObserverTest {
    public static void main(String[] args) {
        Observer observer = new Observer();
        try {
            Method advice = observer.getClass().getMethod("advice", Event.class);
            Subject subject = new Subject();
            subject.addListener(SubjectEventType.ON_ADD, observer, advice);
            subject.addListener(SubjectEventType.ON_REMOVE, observer, advice);
            subject.addListener(SubjectEventType.ON_EDIT, observer, advice);
            subject.addListener(SubjectEventType.ON_QUERY, observer, advice);
            subject.add();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
