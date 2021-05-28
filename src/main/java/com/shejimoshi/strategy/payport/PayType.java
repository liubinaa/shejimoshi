package com.shejimoshi.strategy.payport;

/**
 * @author liubin
 */

public enum PayType {
    /**
     * 支付宝支付
     */
    ALI_PAY(new AliPay()),
    /**
     * 微信支付
     */
    WECHAT_PAY(new WechatPay());

    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }

}
