import com.github.jonashonecker.orders.Order;
import com.github.jonashonecker.orders.OrderRepo;
import com.github.jonashonecker.products.Product;
import com.github.jonashonecker.products.ProductRepo;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService() {
    }

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(Order newOrder) {
        Product productToOrder = productRepo.getSingleById(newOrder.product().productId());
        if (productToOrder == null) {
            System.out.println("The requested product does not exist, Sorry!");
        } else {
            orderRepo.add(newOrder);
            System.out.println("Your product has been found and ordered!");
        }
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }
}