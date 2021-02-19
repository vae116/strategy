package com.study.service.impl;

import com.study.entity.Order;
import com.study.service.OrderService;
import com.study.strategy.OrderStrategy;
import com.study.strategy.processor.HandlerOrderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiehongwei
 * @date 2021/02/19
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HandlerOrderContext handlerOrderContext;

    @Override
    public String handleOrder(Order order) {
        //使用策略处理订单
        OrderStrategy orderStrategy = handlerOrderContext.getOrderStrategy(order.getType());
        return orderStrategy.handleOrder(order);
    }
}
