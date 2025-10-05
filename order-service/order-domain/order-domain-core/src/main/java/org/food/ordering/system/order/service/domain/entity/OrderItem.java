package org.food.ordering.system.order.service.domain.entity;

import org.food.ordering.system.domain.entity.BaseEntity;
import org.food.ordering.system.domain.valuobject.Money;
import org.food.ordering.system.domain.valuobject.OrderId;
import org.food.ordering.system.order.service.domain.valueofobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money money;
    private final Money subTotal;

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId);
        product = builder.product;
        money = builder.money;
        quantity = builder.quantity;
        subTotal = builder.subTotal;
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getMoney() {
        return money;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public static final class Builder {
        private OrderItemId orderItemId;
        private Product product;
        private Money money;
        private int quantity;
        private Money subTotal;

        public Builder() {
        }

        public Builder orderItemId(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder money(Money val) {
            money = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder subTotal(Money val) {
            subTotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
