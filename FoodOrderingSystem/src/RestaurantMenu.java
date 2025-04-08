import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantMenu {
    private Map<String, List<MenuItem>> menu;
    private String restaurantId;

    public RestaurantMenu(String restaurantId) {
        this.restaurantId = restaurantId;
        menu = new HashMap<>();
    }

    public Map<String, List<MenuItem>> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, List<MenuItem>> menu) {
        this.menu = menu;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "menu=" + menu +
                ", restaurantId='" + restaurantId + '\'' +
                '}';
    }
}
