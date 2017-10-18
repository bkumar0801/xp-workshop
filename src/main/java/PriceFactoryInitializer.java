import java.util.HashMap;

public class PriceFactoryInitializer {
    static PriceFactoryInitializer pi = null;
    HashMap<Integer,Price> factories = new HashMap<Integer,Price>();
    private PriceFactoryInitializer() {
        factories.put(Movie.REGULAR, new RegularPrice());
        factories.put(Movie.CHILDRENS, new ChildrensPrice());
        factories.put(Movie.NEW_RELEASE, new NewReleasePrice());
    }

    public static PriceFactoryInitializer getInstance()
    {
        if (pi == null)
            pi = new PriceFactoryInitializer();
        return pi;
    }

    public Price getPriceType(int priceCode) {
        return factories.get(priceCode);
    }
}
