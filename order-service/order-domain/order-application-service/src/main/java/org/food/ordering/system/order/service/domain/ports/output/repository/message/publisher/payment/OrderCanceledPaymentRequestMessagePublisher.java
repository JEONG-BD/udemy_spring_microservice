package org.food.ordering.system.order.service.domain.ports.output.repository.message.publisher.payment;

import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.order.service.domain.event.OrderCancelledEvent;

public interface OrderCanceledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
