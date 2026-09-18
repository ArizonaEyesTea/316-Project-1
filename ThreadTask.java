import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.*;


public class ThreadTask implements Callable<Long> {

    private final long assignedPoints;

    public ThreadTask(long assignedPoints) {
        this.assignedPoints = assignedPoints;
    }

    @Override
    public Long call() {
        Long numberOfPointsInCircle = 0L;
        for(long i = 0; i < assignedPoints; i++){
            double x = ThreadLocalRandom.current().nextDouble(0, 2);
            double y = ThreadLocalRandom.current().nextDouble(0, 2);
            double distance = Math.sqrt((x - 1) * (x - 1) + (y - 1) * (y - 1));

            if (distance <= 1) {
                numberOfPointsInCircle++;
            }
        }
        return numberOfPointsInCircle;
    }
}