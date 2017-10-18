import java.util.HashMap;

public class PriceFactoryInitializer {
    static PriceFactoryInitializer instance;
    static HashMap<Integer,Price> factories = new HashMap<Integer,Price>();
    private PriceFactoryInitializer() {
        factories.put(Movie.REGULAR, new RegularPrice());
        factories.put(Movie.CHILDRENS, new ChildrensPrice());
        factories.put(Movie.NEW_RELEASE, new NewReleasePrice());
    }
    public static PriceFactoryInitializer getInstance(){
        if(instance == null){
            instance = new PriceFactoryInitializer();
        }
        return instance;
    }
    public Price getPriceType(int priceCode) {
        return factories.get(priceCode);
    }
}
