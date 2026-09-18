import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain {
    private static final long totalPoints = 1_000_000;
    static final int threads = 4;
    static int pointsInCircle = 0;
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        ExecutorService es = Executors.newFixedThreadPool(threads);
        long pointsPerThread = totalPoints/threads;

        for (int i = 0; i < threads; i++) {
           es.submit(new ThreadTask(pointsPerThread));
        }

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        double pi = pointsInCircle/(double)totalPoints*4;
        Instant finish = Instant.now();
        long timeElapsed =
                Duration.between(start, finish).toMillis();
        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);
    }
}
