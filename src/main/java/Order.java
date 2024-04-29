import java.math.BigDecimal;

public record Order(
        Product product,
        int amount,
        BigDecimal price,
        String orderId
) {
}
