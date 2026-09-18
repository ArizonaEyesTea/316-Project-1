import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.*;


public class ThreadTask implements Callable<Long> {

    private long totalPoints;
    private long pointsInCircle = 0;

    public ThreadTask(long totalPoints) {
        this.totalPoints = totalPoints;
    }



    @Override
    public Long call() {

        for(long i=0; i<totalPoints; i++){

            double x = ThreadLocalRandom.current().nextDouble(0, 2);
            double y = ThreadLocalRandom.current().nextDouble(0, 2);
            double distance = Math.sqrt((x - 1) * (x - 1) + (y - 1) * (y - 1));
            if (distance <= 1) {
                pointsInCircle++;
            }
    }


        return pointsInCircle;



    }
}
