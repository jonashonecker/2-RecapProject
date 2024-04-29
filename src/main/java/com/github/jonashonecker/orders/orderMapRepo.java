package com.github.jonashonecker.orders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class orderMapRepo implements OrderRepo {
    Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void add(Order newOrder) {
        orderMap.put(newOrder.orderId(), newOrder);
    }

    @Override
    public void remove(Order orderToRemove) {
        orderMap.remove(orderToRemove.orderId());
    }

    @Override
    public Collection<Order> getAll() {
        return orderMap.values();
    }

    @Override
    public Order getSingleById(String orderId) {
        return orderMap.get(orderId);
    }
}
