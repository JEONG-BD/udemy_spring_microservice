package org.food.ordering.system.order.service.domain.entity;

import org.food.ordering.system.domain.entity.AggregateRoot;
import org.food.ordering.system.domain.valuobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean activate;

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        products = builder.products;
        activate = builder.activate;
    }

    public static Builder builder(){
        return new Builder();
    }


    public List<Product> getProducts() {
        return products;
    }

    public boolean isActivate() {
        return activate;
    }

    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean activate;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder activate(boolean val) {
            activate = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
