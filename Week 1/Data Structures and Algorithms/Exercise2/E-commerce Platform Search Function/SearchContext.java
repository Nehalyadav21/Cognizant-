public class SearchContext {

    private SearchStrategy strategy;

    public SearchContext(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public Product executeSearch(Product[] products, int id) {
        return strategy.search(products, id);
    }
}