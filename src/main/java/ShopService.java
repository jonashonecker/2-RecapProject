public class ShopService {
    public void placeOrder(ProductRepo productRepo, Order newOrder) {
        Product productToOrder = productRepo.getProductById(newOrder.product().productId());
        if (productToOrder == null) {
            System.out.println("The requested product does not exist, Sorry!");
        } else {
            System.out.println("Your product has been found and can be ordered!");
        }
    }
}
