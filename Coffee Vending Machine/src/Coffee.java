import java.util.Map;

public class Coffee {
    private final CoffeeType coffeeType;
    private final double price;
    private final Map<Ingredient, Integer> requiredIngredients;

    public Coffee(CoffeeType coffeeType, double price, Map<Ingredient, Integer> requiredIngredients) {
        this.coffeeType = coffeeType;
        this.price = price;
        this.requiredIngredients = requiredIngredients;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public double getPrice() {
        return price;
    }

    public Map<Ingredient, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
