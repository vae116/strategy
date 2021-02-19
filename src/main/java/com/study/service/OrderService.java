package com.study.service;

import com.study.entity.Order;

/**
 * @author xiehongwei
 * @date 2021/02/19
 */
public interface OrderService {
    /**
     * 处理订单
     *
     * @param order
     */
    String handleOrder(Order order);
}
