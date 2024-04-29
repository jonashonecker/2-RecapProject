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

    public Product getProductById(String productID) {
        for (Product p : products) {
            if (productID.equals(p.id())) {
                return p;
            }
        }
        return null;
    }

}
