package com.github.jonashonecker.products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public ProductRepo() {
    }

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public void add(Product newProduct) {
        products.add(newProduct);
    }

    public void remove(Product productToRemove) {
        products.remove(productToRemove);
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getSingleById(String productId) {
        for (Product p : products) {
            if (productId.equals(p.productId())) {
                return p;
            }
        }
        return null;
    }

}
