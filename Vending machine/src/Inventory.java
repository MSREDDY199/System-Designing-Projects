import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> inventory;

    public Inventory() {
        inventory = new ConcurrentHashMap<>();
    }

    // add the product in the inventory
    public void addProduct(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    // update the product quantity
    public void updateQuantity(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    // get the product quantity
    public int getQuantity(Product product) {
        return inventory.getOrDefault(product, 0);
    }

    // is the product available in the inventory
    public boolean isProductAvailable(Product product) {
        return inventory.containsKey(product) && inventory.get(product) > 0;
    }

}
