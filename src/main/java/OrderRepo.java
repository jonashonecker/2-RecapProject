import java.util.List;

public interface OrderRepo {
    void addOrder(Order newOrder);

    void removeOrder(Order orderToRemove);

    List<Order> getAllOrders();

    Order getOrderById(String orderId);
}
