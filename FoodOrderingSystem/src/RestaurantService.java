import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    List<Restaurant> restaurants;

    public RestaurantService() {
        restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void showRestaurants () {
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }

    public void showRestaurantMenu(String restaurantId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId().equals(restaurantId)) {
                RestaurantMenu restaurantMenu = restaurant.getRestaurantMenu();
                for (String category : restaurantMenu.getMenu().keySet()) {
                    System.out.println(restaurantMenu.getMenu().get(category));
                }
            }
        }
    }

    public void showOrders(String restaurantId, List<Order> orders) {
        for (Order order : orders) {
            if (order.getItems().containsKey(restaurantId)) {
                System.out.println(order);
            }
        }
    }

    public void showInProcessOrders(String restaurantId, List<Order> orders) {
        for (Order order : orders) {
            if (order.getItems().containsKey(restaurantId)) {
                System.out.println(order);
            }
        }
    }

    public void addMenu(String restaurantId, MenuItem menuItem) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId().equals(restaurantId)) {
                restaurant.getRestaurantMenu().getMenu().putIfAbsent(menuItem.getCategory(), new ArrayList<>());
                restaurant.getRestaurantMenu().getMenu().get(menuItem.getCategory()).add(menuItem);
            }
        }
    }
}
