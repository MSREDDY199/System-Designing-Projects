public class Payment {
    private String id;
    private String paymentMethod;
    private String status;
    private double amount;
    private String orderId;

    public Payment(String id, String paymentMethod, String status, double amount, String orderId) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.amount = amount;
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
