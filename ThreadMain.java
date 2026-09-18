import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {
    private static final long totalPoints = 1_000_000;

    public static void main(String[] args) {
        long pointsInCircle = 0;
        long totalPoints = 0;
        Instant start = Instant.now();
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000000; i++) {
            es.submit(new ThreadTask(Long totalPoints));
        }



        double pi = pointsInCircle/(double)totalPoints*4;
        Instant finish = Instant.now();
        long timeElapsed =
                Duration.between(start, finish).toMillis();
        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);
    }
}
