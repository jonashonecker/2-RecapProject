package com.github.jonashonecker.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo{
    List<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order newOrder) {
        orderList.add(newOrder);
    }

    @Override
    public void remove(Order orderToRemove) {
        orderList.remove(orderToRemove);
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public Order getSingleById(String orderId) {
        for (Order o : orderList) {
            if (orderId.equals(o.orderId())) {
                return o;
            }
        }
        return null;
    }
}
