package com.shejimoshi.strategy.payport;

import com.shejimoshi.strategy.PayState;

import java.math.BigDecimal;

/**
 * @author liubin
 */
public interface Payment {
    Payment aliPay = new AliPay();
    Payment wechatPay = new WechatPay();

    /**
     * 支付
     * @param uid UID
     * @param amount 金额
     * @return 支付状态
     */
    PayState pay(String uid, BigDecimal amount);
}
