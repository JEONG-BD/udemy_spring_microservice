package org.food.ordering.system.order.service.domain.valueofobject;

import org.food.ordering.system.domain.valuobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID value) {
        super(value);
    }
}
