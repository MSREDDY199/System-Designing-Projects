import java.util.Map;
import java.util.UUID;

public class Expense {

    private String expenseId;
    private double amount;
    private User paidBy;
    private Map<User, Double> splitInfo;

    public Expense(double amount, User paidBy, Map<User, Double> splitInfo) {
        this.expenseId = UUID.randomUUID().toString();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitInfo = splitInfo;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public Map<User, Double> getSplitInfo() {
        return splitInfo;
    }

    public void setSplitInfo(Map<User, Double> splitInfo) {
        this.splitInfo = splitInfo;
    }
}
