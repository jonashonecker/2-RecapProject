import com.github.jonashonecker.orders.Order;
import com.github.jonashonecker.orders.*;
import com.github.jonashonecker.orders.OrderRepo;
import com.github.jonashonecker.products.Product;
import com.github.jonashonecker.products.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ShopServiceTest {
    ShopService shop = new ShopService();

    static Stream<OrderRepo> orderRepoProvider() {
        return Stream.of(new OrderListRepo(), new OrderMapRepo());
    }

    void setUp(OrderRepo orderRepo) {
        Product product1 = new Product("abc", new BigDecimal("0.99"), "AAA");
        Product product2 = new Product("def", new BigDecimal("1.99"), "BBB");
        Order order1 = new Order(product1, 1, new BigDecimal("99.99"), "AAA1");
        Order order2 = new Order(product2, 1, new BigDecimal("99.99"), "BBB1");
        ProductRepo productRepo = new ProductRepo(List.of(product1, product2));
        orderRepo.add(order1);
        orderRepo.add(order2);
        shop = new ShopService(productRepo, orderRepo);
    }

    @AfterEach
    void tearDown() {
        shop = new ShopService();
    }

    @ParameterizedTest
    @MethodSource("orderRepoProvider")
    void placeOrder_whenProductExistAddOrderToOrderRepo(OrderRepo orderRepo) {
        // Given
        setUp(orderRepo);
        Order newOrder = new Order(new Product("abc", new BigDecimal("0.99"), "AAA"), 3, new BigDecimal("33.33"), "abc");

        // When
        shop.placeOrder(newOrder);

        // THEN
        assertThat(shop.getOrderRepo().getAll()).contains(newOrder);
    }

    @ParameterizedTest
    @MethodSource("orderRepoProvider")
    void placeOrder_whenProductDoesNotExistDontAddOrderToOrderRepo(OrderRepo orderRepo) {
        // Given
        setUp(orderRepo);
        Order newOrder = new Order(new Product("gfd", new BigDecimal("99.99"), "bch"), 3, new BigDecimal("33.33"), "abc");

        // When
        shop.placeOrder(newOrder);

        // THEN
        assertThat(shop.getOrderRepo().getAll()).doesNotContain(newOrder);
    }
}