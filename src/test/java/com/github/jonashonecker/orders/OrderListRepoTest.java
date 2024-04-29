package com.github.jonashonecker.orders;

import com.github.jonashonecker.products.Product;
import com.github.jonashonecker.products.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {
    OrderRepo orderRepo = new OrderListRepo();

    @BeforeEach
    void setUp() {
        Product product1 = new Product("abc", new BigDecimal("0.99"), "AAA");
        Product product2 = new Product("def", new BigDecimal("1.99"), "BBB");
        orderRepo.add(new Order(product1, 1, new BigDecimal("99.99"), "AAA1"));
        orderRepo.add(new Order(product2, 1, new BigDecimal("99.99"), "BBB1"));
    }

    @AfterEach
    void clearSetup() {
        orderRepo = new OrderListRepo();
    }

    @Test
    void add_WhenOrderAddedThenOrderIsInList() {
        // GIVEN
        Product newProduct = new Product("xxx", new BigDecimal("4.99"), "83U");
        Order newOrder = new Order(newProduct, 3, new BigDecimal("33.33"), "xxx111");

        // WHEN
        orderRepo.add(newOrder);

        // THEN
        assertThat(orderRepo.getAll()).contains(newOrder);
    }

    @Test
    void remove_WhenOrderIsRemovedThenOrderIsNotInList() {
        // GIVEN
        Product newProduct = new Product("xxx", new BigDecimal("4.99"), "83U");
        Order newOrder = new Order(newProduct, 3, new BigDecimal("33.33"), "xxx111");

        // WHEN
        orderRepo.remove(newOrder);

        // THEN
        assertThat(orderRepo.getAll()).doesNotContain(newOrder);
    }

    @Test
    void getAll_WhenOrderIsAddedThenOrderIsInList() {
        // GIVEN
        Product newProduct = new Product("xxx", new BigDecimal("4.99"), "83U");
        Order newOrder = new Order(newProduct, 3, new BigDecimal("33.33"), "xxx111");

        // WHEN
        orderRepo.add(newOrder);

        // THEN
        assertThat(orderRepo.getAll()).contains(newOrder);
    }

    @Test
    void getSingleById_whenIdNotPresentReturnsNull() {
        assertNull(orderRepo.getSingleById("123456"));
    }

    @Test
    void getSingleById_whenIdAAAReturnCorrectProduct() {
        // GIVEN
        Product product1 = new Product("abc", new BigDecimal("0.99"), "AAA");
        Order expected = new Order(product1, 1, new BigDecimal("99.99"), "AAA1");

        // WHEN
        Order actual = orderRepo.getSingleById("AAA1");

        // THEN
        assertThat(actual).isEqualTo(expected);
    }
}