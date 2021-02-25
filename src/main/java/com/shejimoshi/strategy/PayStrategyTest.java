package com.shejimoshi.strategy;

import com.shejimoshi.strategy.payport.PayType;

import java.math.BigDecimal;

/**
 * @author liubin
 */
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "202102250001", new BigDecimal(233));

        //开始支付，选择支付方式
        //每个渠道的支付的算法是不一样的
        //这个值是在支付的时候才决定用哪个值
        PayState pay = order.pay(PayType.ALI_PAY);
        System.out.println(pay.getMsg());
    }
}
