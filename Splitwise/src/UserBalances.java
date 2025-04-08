import java.util.HashMap;
import java.util.Map;

public class UserBalances {

    private Map<User, Map<User, Double>> balances;

    public UserBalances() {
        balances = new HashMap<>();
    }

    public void updateBalance(User paidBy, Map<User, Double> splitInfo) {
        for (Map.Entry<User, Double> entry : splitInfo.entrySet()) {
            User participant = entry.getKey();
            double amount = entry.getValue();

            balances.putIfAbsent(paidBy, new HashMap<>());
            balances.putIfAbsent(participant, new HashMap<>());

            balances.get(paidBy).put(participant, balances.get(paidBy).getOrDefault(participant, 0.0) + amount);
            balances.get(participant).put(paidBy, balances.get(participant).getOrDefault(paidBy, 0.0) - amount);
        }
    }

    public void showBalances() {
        for (Map.Entry<User, Map<User, Double>> entry : balances.entrySet()) {
            User user = entry.getKey();
            Map<User, Double> userBalances = entry.getValue();

            for (Map.Entry<User, Double> balanceEntry : userBalances.entrySet()) {
                if (balanceEntry.getValue() > 0) {
                    System.out.println(user + " owes " + balanceEntry.getKey() + ": " + balanceEntry.getValue());
                }
            }
        }
    }

    public void showBalance(User user) {
        Map<User, Double> userBalances = balances.get(user);
        if (userBalances != null) {
            for (Map.Entry<User, Double> balanceEntry : userBalances.entrySet()) {
                if (balanceEntry.getValue() > 0) {
                    System.out.println(user + " owes " + balanceEntry.getKey() + ": " + balanceEntry.getValue());
                }
            }
        }
    }
}
