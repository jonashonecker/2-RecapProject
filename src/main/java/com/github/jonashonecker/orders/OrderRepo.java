package com.github.jonashonecker.orders;

import java.util.Collection;

public interface OrderRepo {
    void add(Order newOrder);

    void remove(Order orderToRemove);

    Collection<Order> getAll();

    Order getSingleById(String orderId);
}
