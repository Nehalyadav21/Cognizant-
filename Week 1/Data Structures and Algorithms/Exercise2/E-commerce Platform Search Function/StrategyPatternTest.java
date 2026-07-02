import java.util.Arrays;
import java.util.Comparator;

public class StrategyPatternTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Keyboard"),
                new Product(101, "Laptop"),
                new Product(104, "Monitor"),
                new Product(102, "Mouse")
        };

        // Linear Search
        SearchContext context = new SearchContext(new LinearSearch());

        Product result = context.executeSearch(products, 102);

        if (result != null)
            System.out.println("Linear Search: " + result.getName());

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparingInt(Product::getId));

        context = new SearchContext(new BinarySearch());

        result = context.executeSearch(products, 104);

        if (result != null)
            System.out.println("Binary Search: " + result.getName());
    }
}