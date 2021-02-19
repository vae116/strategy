package com.study.strategy;

import com.study.entity.Order;

/**
 * 处理订单策略
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
public interface OrderStrategy {
    /**
     * 处理订单
     *
     * @param order
     */
    String handleOrder(Order order);
}
