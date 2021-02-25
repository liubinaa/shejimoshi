package com.shejimoshi.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liubin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayState {
    private int code;
    private Object data;
    private String msg;
}
