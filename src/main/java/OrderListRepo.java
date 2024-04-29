import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    List<Order> orderList = new ArrayList<>();

    public void addOrder(Order newOrder) {
        orderList.add(newOrder);
    }

    public void removeOrder(Order orderToRemove) {
        orderList.remove(orderToRemove);
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order getOrderById(String productID) {
        for (Order o : orderList) {
            if (productID.equals(o.orderId())) {
                return o;
            }
        }
        return null;
    }
}