package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order extends PriceCalculator {

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
       super(orderLineItemList,discounts,new BigDecimal(0.1));
    }
}
