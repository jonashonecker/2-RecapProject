package com.github.jonashonecker.products;

import java.math.BigDecimal;

public record Product(
        String name,
        BigDecimal price,
        String productId
) {
}
