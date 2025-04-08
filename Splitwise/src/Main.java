import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("1", "Alice", "alice@example.com");
        User user2 = new User("2", "Bob", "bob@example.com");
        User user3 = new User("3", "Charlie", "charlie@example.com");

        ExpenseService expenseService = new ExpenseService();

        // Example: Equal split
        expenseService.addExpense(300, user1, Arrays.asList(user1, user2, user3), new EqualSplit(), null);
        expenseService.showBalances();

        // Example: Exact split
        expenseService.addExpense(300, user2, Arrays.asList(user1, user2, user3), new ExactSplit(), Arrays.asList(100.0, 100.0, 100.0));
        expenseService.showBalances();

        // Example: Percentage split
        expenseService.addExpense(300, user3, Arrays.asList(user1, user2, user3), new PercentageSplit(), Arrays.asList(40.0, 40.0, 20.0));
        expenseService.showBalances();
    }
}