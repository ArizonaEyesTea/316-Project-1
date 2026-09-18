import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.*;


public class ThreadTask implements Runnable {

    private final long assignedPoints;

    public ThreadTask(long assignedPoints) {
        this.assignedPoints = assignedPoints;
    }

    @Override
    public void run() {
        for(long i = 0; i < assignedPoints; i++){
            double x = ThreadLocalRandom.current().nextDouble(0, 2);
            double y = ThreadLocalRandom.current().nextDouble(0, 2);
            double distance = Math.sqrt((x - 1) * (x - 1) + (y - 1) * (y - 1));

            if (distance <= 1) {
                ThreadMain.lock.lock();
                try {
                    ThreadMain.pointsInCircle++;
                } finally {
                    ThreadMain.lock.unlock();
                }
            }
        }
    }
}