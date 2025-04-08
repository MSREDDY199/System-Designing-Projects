import java.util.List;
import java.util.Map;

public class Order {
    private String id;
    private String userId;
    private OrderStatus orderStatus;
    private Payment payment;
    private Map<String, List<MenuItem>> items; // restaurant id, list of menu items

    public Order(String id, String userId, OrderStatus orderStatus, Payment payment, Map<String, List<MenuItem>> items) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Map<String, List<MenuItem>> getItems() {
        return items;
    }

    public void setItems(Map<String, List<MenuItem>> items) {
        this.items = items;
    }
}
