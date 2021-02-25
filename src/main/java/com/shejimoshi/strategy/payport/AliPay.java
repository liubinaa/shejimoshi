package com.shejimoshi.strategy.payport;

import com.shejimoshi.strategy.PayState;

import java.math.BigDecimal;

/**
 * @author liubin
 */
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, BigDecimal amount) {
        System.out.println("欢迎使用支付宝");

        return new PayState(200, amount,  "支付成功");
    }
}
