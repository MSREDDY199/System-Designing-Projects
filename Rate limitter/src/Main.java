//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new TokenBucketRateLimiter(200, 100);

        String userId = "user123";

        for (int i = 0; i < 6; i++) {
            boolean isRateLimited = rateLimiter.isRateLimited(userId, 50);
            System.out.println("Request " + (i + 1) + ": " + (isRateLimited ? "Rate Limited" : "Allowed"));
            Thread.sleep(200); // Simulate some delay between requests
        }
    }
}