import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    private List<Expense> expenses;
    private UserBalances balanceManager;

    public ExpenseService() {
        expenses = new ArrayList<>();
        balanceManager = new UserBalances();
    }

    public void addExpense(double amount, User paidBy, List<User> participants, SplitTypes splitStrategy, List<Double> splitDetails) {
        Map<User, Double> splitInfo = splitStrategy.calculateSplit(amount, participants, splitDetails);
        Expense expense = new Expense(amount, paidBy, splitInfo);
        expenses.add(expense);
        balanceManager.updateBalance(paidBy, splitInfo);
    }

    public void showBalances() {
        balanceManager.showBalances();
    }

    public void showBalance(User user) {
        balanceManager.showBalance(user);
    }
}
