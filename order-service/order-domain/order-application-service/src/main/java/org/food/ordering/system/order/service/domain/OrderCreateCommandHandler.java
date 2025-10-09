package org.food.ordering.system.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import org.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import org.food.ordering.system.order.service.domain.entity.Customer;
import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import org.food.ordering.system.order.service.domain.exception.OrderDomainException;
import org.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import org.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import org.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import org.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {


    private final OrderDataMapper orderDataMapper;

    private final OrderCreateHelper orderCreateHelper;

    public OrderCreateCommandHandler(OrderDataMapper orderDataMapper,
                                     OrderCreateHelper orderCreateHelper) {
        this.orderDataMapper = orderDataMapper;
        this.orderCreateHelper = orderCreateHelper;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand){
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order  is created with Id : {}", orderCreatedEvent.getOrder().getId());
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder());

    }

}
