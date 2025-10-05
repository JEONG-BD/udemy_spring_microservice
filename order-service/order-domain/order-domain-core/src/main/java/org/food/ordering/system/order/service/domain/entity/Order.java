package org.food.ordering.system.order.service.domain.entity;

import org.food.ordering.system.domain.entity.AggregateRoot;
import org.food.ordering.system.domain.valuobject.CustomerId;
import org.food.ordering.system.domain.valuobject.OrderId;
import org.food.ordering.system.domain.valuobject.RestaurantId;

public class Order extends AggregateRoot<OrderId> {

    private final CustomerId customerId;
    private final RestaurantId restaurantId;
    private final StreetAddress

}
