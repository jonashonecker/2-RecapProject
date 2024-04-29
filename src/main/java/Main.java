import com.github.jonashonecker.products.*;
import com.github.jonashonecker.orders.*;

public class Main {
    public static void main(String[] args) {
        ProductRepo myProductRepo = new ProductRepo();
        OrderRepo myOrderListRepo = new OrderListRepo();
        OrderRepo myOrderMapRepo = new OrderListRepo();
        ShopService myListShop = new ShopService(myProductRepo, myOrderListRepo);
        ShopService myMapShop = new ShopService(myProductRepo, myOrderMapRepo);
    }
}
