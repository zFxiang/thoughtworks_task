package practice2;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal tax;

    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = calculateSubTotal(products, items);
        subTotal = deductOfPriceReductionWithTotal(products, items, subTotal);
        BigDecimal grandTotal = calculateGrandTotal(subTotal);
        return grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private BigDecimal deductOfPriceReductionWithTotal(List<Product> products, List<OrderItem> items, BigDecimal subTotal) {
        for (Product product : products) {
            subTotal = deductOfPriceReductionWithProduct(product, items, subTotal);
        }
        return subTotal;
    }

    private BigDecimal calculateGrandTotal(BigDecimal subTotal) {
        BigDecimal taxTotal = subTotal.multiply(tax);
        return subTotal.add(taxTotal);
    }

    private BigDecimal deductOfPriceReductionWithProduct(Product product, List<OrderItem> items, BigDecimal subTotal) {
        OrderItem curItem = findOrderItemByProduct(items, product);
        if (curItem == null) {
            return subTotal;
        }
        BigDecimal reducedPrice = getReducedPrice(product, curItem.getCount());
        return subTotal.subtract(reducedPrice);
    }

    private BigDecimal getReducedPrice(Product product, int count) {
        return product.getPrice()
                .multiply(product.getDiscountRate())
                .multiply(new BigDecimal(count));
    }


    private OrderItem findOrderItemByProduct(List<OrderItem> items, Product product) {
        for (OrderItem item : items) {
            if (equals(product, item)) {
                return item;
            }
        }
        return null;
    }

    private boolean equals(Product product, OrderItem item) {
        return item.getCode() == product.getCode();
    }

    private BigDecimal calculateSubTotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            OrderItem item = findOrderItemByProduct(items, product);
            BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(item.getCount()));
            subTotal = subTotal.add(itemTotal);
        }
        return subTotal;
    }
}
