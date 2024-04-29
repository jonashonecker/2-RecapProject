package com.github.jonashonecker.products;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    ProductRepo productRepo = new ProductRepo();

    @BeforeEach
    void setUp() {
        productRepo.add(new Product("abc", new BigDecimal("0.99"), "AAA"));
        productRepo.add(new Product("def", new BigDecimal("1.99"), "BBB"));
        productRepo.add(new Product("ghi", new BigDecimal("2.99"), "CCC"));
        productRepo.add(new Product("jkl", new BigDecimal("3.99"), "DDD"));
    }

   @AfterEach
   void clearSetup() {
        productRepo = new ProductRepo();
   }

   @Test
   void add_whenProductAddedThenProductIsInList(){
        // GIVEN
       Product newProduct = new Product("xxx", new BigDecimal("4.99"), "83U");

       // WHEN
       productRepo.add(newProduct);

       // THEN
       assertThat(productRepo.getAll()).contains(newProduct);
   }

    @Test
    void remove_whenProductRemovedThenProductIsNotInList(){
        // GIVEN
        Product newProduct = new Product("abc", new BigDecimal("0.99"), "AAA");

        // WHEN
        productRepo.remove(newProduct);

        // THEN
        assertThat(productRepo.getAll()).doesNotContain(newProduct);
    }

    @Test
    void getAll_whenProductAddedThenProductIsInList(){
        // GIVEN
        Product newProduct = new Product("xxx", new BigDecimal("4.99"), "83U");

        // WHEN
        productRepo.add(newProduct);

        // THEN
        assertThat(productRepo.getAll()).contains(newProduct);
    }

    @Test
    void getSingleById_whenIdNotPresentReturnsNull() {
        assertNull(productRepo.getSingleById("123456"));
    }

    @Test
    void getSingleById_whenIdAAAReturnCorrectProduct() {
        // GIVEN
        Product expected = new Product("abc", new BigDecimal("0.99"), "AAA");

        // WHEN
        Product actual = productRepo.getSingleById("AAA");

        // THEN
        assertEquals(expected, actual);
    }
}