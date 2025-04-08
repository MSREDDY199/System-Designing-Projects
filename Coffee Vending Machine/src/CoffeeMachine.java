import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private static CoffeeMachine coffeeMachine;
    private List<Coffee> coffees;
    private Map<String, Ingredient> ingredients;

    private CoffeeMachine() {
        coffees = new ArrayList<>();
        ingredients = new HashMap<>();
        initializeIngredients();
        initializeCoffee();
    }

    public static CoffeeMachine getInstance() {
        coffeeMachine = new CoffeeMachine();
        return coffeeMachine;
    }

    public void initializeIngredients() {
        Ingredient coffee = new Ingredient("Coffee", 10);
        Ingredient milk = new Ingredient("Milk", 10);
        Ingredient water = new Ingredient("water", 10);

        ingredients.put("coffee", coffee);
        ingredients.put("milk", milk);
        ingredients.put("water", water);
    }

    public void initializeCoffee() {
        Map<Ingredient, Integer> cappuccino = new HashMap<>();
        cappuccino.put(ingredients.get("coffee"), 1);
        cappuccino.put(ingredients.get("water"), 2);
        cappuccino.put(ingredients.get("milk"), 2);
        coffees.add(new Coffee(CoffeeType.CAPPUCCINO, 100.0, cappuccino));

        Map<Ingredient, Integer> espresso = new HashMap<>();
        espresso.put(ingredients.get("coffee"), 1);
        espresso.put(ingredients.get("water"), 1);
        espresso.put(ingredients.get("milk"), 2);
        coffees.add(new Coffee(CoffeeType.ESPRESSO, 90.0, espresso));

        Map<Ingredient, Integer> latte = new HashMap<>();
        latte.put(ingredients.get("coffee"), 1);
        latte.put(ingredients.get("water"), 1);
        latte.put(ingredients.get("milk"), 2);
        coffees.add(new Coffee(CoffeeType.LATTE, 80.0, latte));
    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (Coffee coffee : coffees) {
            System.out.println(coffee.getCoffeeType() + " - $" + coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(CoffeeType coffeeName) {
        for (Coffee coffee : coffees) {
            if (coffee.getCoffeeType() == coffeeName) {
                return coffee;
            }
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getCoffeeType() + "...");
                double change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getCoffeeType());
            }
        } else {
            System.out.println("Insufficient payment for " + coffee.getCoffeeType());
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRequiredIngredients().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            if (ingredient.getQuantity() < requiredQuantity) {
                return false;
            }
        }
        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRequiredIngredients().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }
}
