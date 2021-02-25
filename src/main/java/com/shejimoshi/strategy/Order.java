package com.shejimoshi.strategy;

import com.shejimoshi.strategy.payport.PayType;
import com.shejimoshi.strategy.payport.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author liubin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String uid;
    private String orderId;
    private BigDecimal amount;

    /**
     * 这个参数为什么砽Payment接口来替代？
     *
     * 完美的解决了switch的过程，不需要在代码逻辑中写Switch，更不需要写if了
     *
     * @param payType 付款类型
     * @return 支付状态
     */
    public PayState pay(PayType payType) {
        return payType.get().pay(this.uid, this.amount);
    }
}
