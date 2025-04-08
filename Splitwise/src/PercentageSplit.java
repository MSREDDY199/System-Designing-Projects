import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements SplitTypes{

    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, List<Double> splitDetails) {
        Map<User, Double> splitInfo = new HashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            splitInfo.put(participants.get(i), (amount * splitDetails.get(i)) / 100);
        }
        return splitInfo;
    }
}
