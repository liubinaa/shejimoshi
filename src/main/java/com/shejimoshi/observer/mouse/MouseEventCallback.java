package com.shejimoshi.observer.mouse;

import com.shejimoshi.observer.core.Event;
import com.shejimoshi.observer.core.EventListener;

/**
 * 回调响应的逻辑，由自己实现
 *
 * @author liubin
 */
public class MouseEventCallback extends EventListener {
    public void onClick(Event event) {
        System.out.println("这是鼠标单击后要执行的逻辑");
        System.out.println("==============触发鼠标单击事件===============\n" + event);
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void onDoubleClick(Event event) {
        System.out.println("==============触发鼠标双击事件===============\n" + event);
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void onUp(Event event) {
        System.out.println("==============触发鼠标弹起事件===============\n" + event);
        this.trigger(MouseEventType.ON_UP);
    }

    public void onDown(Event event) {
        System.out.println("==============触发鼠标按下事件===============\n" + event);
        this.trigger(MouseEventType.ON_DOWN);
    }

    public void onWheel(Event event) {
        System.out.println("==============触发鼠标滚动事件===============\n" + event);
        this.trigger(MouseEventType.ON_WHEEL);
    }

    public void onMove(Event event) {
        System.out.println("==============触发鼠标移动事件===============\n" + event);
        this.trigger(MouseEventType.ON_MOVE);
    }

    public void onOver(Event event) {
        System.out.println("==============触发鼠标悬停事件===============\n" + event);
        this.trigger(MouseEventType.ON_OVER);
    }
}
