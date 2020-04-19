package Lesson_5.hw.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    public static CountDownLatch cdlStart;
    public static CountDownLatch cdlStop;
    public static CyclicBarrier cyclicBarrier;
    private static boolean winner;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdlStart, CountDownLatch cdlStop, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdlStart = cdlStart;
        this.cdlStop = cdlStop;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlStart.countDown();
            for (int i = 0; i < race.getStages().size(); i++) {
                if (i == 0) cyclicBarrier.await();  // ждем всех для одновременного старта, потоки стартанут после того как каждый пройдет рубеж i=0
                race.getStages().get(i).go(this); // стартуют все!

                if (i == race.getStages().size()-1) { // достижение последнего этапа в маршруте
                    cdlStop.countDown(); // ставим защелку
                    if(!winner) {
                        System.out.println(this.name + " WIN");
                        winner = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}