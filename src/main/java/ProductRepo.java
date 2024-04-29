import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public void removeProduct(Product productToRemove) {
        products.remove(productToRemove);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String productId) {
        for (Product p : products) {
            if (productId.equals(p.productId())) {
                return p;
            }
        }
        return null;
    }

}
