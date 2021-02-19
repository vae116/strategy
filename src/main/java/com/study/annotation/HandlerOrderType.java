package com.study.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义策略注解
 *
 * @author xiehongwei
 * @date 2021/02/19
 */
@Target(ElementType.TYPE)//作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited//子类可以继承此注解
public @interface HandlerOrderType {
    /**
     * 策略类型
     */
    int value();
}
