import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public void showUsersOrders(String userId, List<Order> orders) {
        for (Order order: orders) {
            if (order.getUserId().equals(userId)) {
                System.out.println(order);
            }
        }
    }

    public void addItem(Order order, String restaurantId, MenuItem menuItem) {
        order.getItems().putIfAbsent(restaurantId, new ArrayList<MenuItem>());
        order.getItems().get(restaurantId).add(menuItem);
    }

    public void removeItem(Order order,  String restaurantId, MenuItem menuItem) {
        order.getItems().get(restaurantId).remove(menuItem);
    }

    public void makePayment(double amount, Order order) {

    }

    public void placeOrder(Order order) {

    }
}
