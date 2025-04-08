import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter{
    Map<String, Integer> userTokens;
    Map<String, Long> lastExecuted;
    private final int bucketCapacity;
    private final int refillRate; // Tokens per second

    public TokenBucketRateLimiter(int bucketCapacity, int refillRate) {
        this.userTokens = new ConcurrentHashMap<>();
        this.lastExecuted = new ConcurrentHashMap<>();
        this.bucketCapacity = bucketCapacity;
        this.refillRate = refillRate;
    }

    @Override
    public boolean isRateLimited(String user_id, int reqTokens) {
        userTokens.putIfAbsent(user_id, 0);
        lastExecuted.putIfAbsent(user_id, System.nanoTime());
        refill(user_id);
        if (userTokens.get(user_id) >= reqTokens) {
            userTokens.put(user_id, userTokens.get(user_id) - reqTokens);
            return false; // not limited
        }
        return true; // rate limited
    }

    public void refill(String user_id) {
        long now = System.nanoTime();
        long timeSinceLastRefill = now - lastExecuted.get(user_id);

        // Calculate how many tokens to add
        double tokensToAdd = (timeSinceLastRefill / 1_000_000_000.0) * refillRate;

        userTokens.put(user_id,  Math.min(bucketCapacity, userTokens.get(user_id) + (int) tokensToAdd));
        lastExecuted.put(user_id, now); // Don't exceed the bucket capacity
    }
}
