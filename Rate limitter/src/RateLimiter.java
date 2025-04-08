public interface RateLimiter {
    boolean isRateLimited(String user_id, int reqTokens);
}
