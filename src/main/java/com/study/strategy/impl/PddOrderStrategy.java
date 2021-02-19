package com.study.strategy.impl;

import com.study.annotation.HandlerOrderType;
import com.study.constant.OrderConstant;
import com.study.entity.Order;
import com.study.strategy.OrderStrategy;
import org.springframework.stereotype.Component;

/**
 * 拼多多订单-策略类
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
@Component
@HandlerOrderType(OrderConstant.PDD) //使用注解标明策略类型
public class PddOrderStrategy implements OrderStrategy {

    @Override
    public String handleOrder(Order order) {
        return "----拼多多订单----";
    }
}
