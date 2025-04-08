import java.util.List;
import java.util.Map;

public interface SplitTypes {
    Map<User, Double> calculateSplit(double amount, List<User> participants, List<Double> splitDetails);
}
