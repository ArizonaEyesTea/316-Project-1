
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadedPi {
    private static final long totalPoints = 1_000_000;

    public static void main(String[] args) {
        Instant start = Instant.now();
        long pointsInCircle = 0;
        for(long i=0; i<totalPoints; i++){
            double x = ThreadLocalRandom.current().nextDouble(0,2);
            double y = ThreadLocalRandom.current().nextDouble(0,2);
            double distance = Math.sqrt((x-1)*(x-1)+(y-1)*(y-1));
            if(distance<=1){
                pointsInCircle++;
            }
        }
        double pi = pointsInCircle/(double)totalPoints*4;
        Instant finish = Instant.now();
        long timeElapsed =
                Duration.between(start, finish).toMillis();
        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);
    }

}

