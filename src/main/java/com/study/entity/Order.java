package com.study.entity;

import lombok.Data;

/**
 * 订单业务实体
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
@Data
public class Order {
    /**
     * 名称
     */
    private String name;
    /**
     * 金额
     */
    private Double price;
    /**
     * 订单类型
     */
    private Integer type;


    public Order() {
    }

    public Order(String name, Double price, Integer type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
