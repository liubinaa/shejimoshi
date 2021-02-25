package com.shejimoshi.factory.abstr;

/**
 * @author liubin
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();
        //对于用户而言更加简单，用户只有选择的权利，保证了程序的健壮性
        System.out.println(factory.getYili().getName());
    }
}
