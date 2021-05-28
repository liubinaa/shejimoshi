package com.shejimoshi.observer.mouse;

import com.shejimoshi.observer.core.Event;

import java.lang.reflect.Method;

/**
 * 如果做过swing开发的话，有一种似曾相识的感觉
 * 监听器用的就是观察者模式，适用范围：监听器、日志收集、短信通知、邮件通知
 *
 * @author liubin
 */
public class MouseTest {
    public static void main(String[] args) {
        /**
         * 在js的写法
         * var input = document.getElementById("username");
         * input.addListener("click", function() {
         *     alert("鼠标点击了这个文本框")
         * })
         */
        //观察者和被观察者之间没有必然的联系，注册的时候，才产生联系
        //解耦
        Mouse mouse = new Mouse();
        try {
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);
            //加上这个事件的某个监听
            mouse.addListener(MouseEventType.ON_CLICK, new MouseEventCallback(), onClick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mouse.click();
    }
}
