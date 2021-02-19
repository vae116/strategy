#注解式-策略模式

### 整体思路

通过注解在策略类上指定约定好的type,项目启动之后将所有有注解的type获取到,根据type存储,然后在业务中根据type获取对应的策略即可

模拟订单业务,根据订单的type,需要不同的处理逻辑,比如：淘宝订单、京东订单、拼多多等


### 测试

测试用例如下：

```java
public class StrategyTest {
    @Test
        public void handler() {
            try {
                String url = "http://localhost:8080/order/handler";
                Order order = new Order();
                order.setName("订单名称");
                order.setPrice(19.9);
    //            order.setType(OrderConstant.TB);//淘宝
    //            order.setType(OrderConstant.JD);//京东
                order.setType(OrderConstant.PDD);//拼多多

                post(url, JSON.toJSONString(order));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
```

返回结果
```
2021-02-19 15:15:12 [main] INFO  com.study.StrategyTest -返回结果：----淘宝订单----
2021-02-19 15:15:28 [main] INFO  com.study.StrategyTest -返回结果：----京东订单----
2021-02-19 15:15:35 [main] INFO  com.study.StrategyTest -返回结果：----拼多多订单----
```



