package com.github.jonashonecker.orders;

import com.github.jonashonecker.products.Product;
import java.math.BigDecimal;

public record Order(
        Product product,
        int amount,
        BigDecimal price,
        String orderId
) {
}
