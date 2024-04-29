package com.github.jonashonecker.orders;

import com.github.jonashonecker.products.Product;
import java.math.BigDecimal;

public record Order(
        Product product,
        int quantity,
        BigDecimal totalPrice,
        String orderId
) {
}
