public class LinearSearch implements SearchStrategy {

    @Override
    public Product search(Product[] products, int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}