import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitTypes{
    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, List<Double> splitDetails) {
        Map<User, Double> splitInfo = new HashMap<>();
        double equalShare = amount / participants.size();
        for (User participant : participants) {
            splitInfo.put(participant, equalShare);
        }
        return splitInfo;
    }
}
