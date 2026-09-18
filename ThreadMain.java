import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain {
    private static final long totalPoints = 10_000_000_000L;
    static final int threads = 4;
    static Long pointsInCircle = 0L;
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(threads);
        long pointsPerThread = totalPoints/threads;
        List<Future<Long>> resultsList = new LinkedList<>();

        Instant start = Instant.now();
        for (int i = 0; i < threads; i++) {
           Future<Long> result = es.submit(new ThreadTask(pointsPerThread));
           resultsList.add(result);
        }

        for (Future<Long> f : resultsList) {
            pointsInCircle += f.get();
        }
        es.shutdown();
        Instant finish = Instant.now();

        double pi = pointsInCircle/(double)totalPoints*4;

        long timeElapsed =
                Duration.between(start, finish).toMillis();
        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);
    }
}
