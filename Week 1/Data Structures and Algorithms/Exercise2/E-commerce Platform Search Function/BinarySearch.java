public class BinarySearch implements SearchStrategy {

    @Override
    public Product search(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].getId() == id)
                return products[mid];

            if (products[mid].getId() < id)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }
}