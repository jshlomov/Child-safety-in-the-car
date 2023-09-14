import AlarmClock.AlarmClock;
import lowLevel.HeatSensor;
import lowLevel.WeightSensor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Random;

public class Main {

    public static Random random = new Random();
    private static final long CLOCK_INTERVAL_MILLIS = 100;
    static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {

        AlarmClock alarmClock = container.select(AlarmClock.class).get();

        WeightSensor ws = new WeightSensor(alarmClock, 1000,
                data -> data > 2, () -> {
            return random.nextInt(6);
        });
        HeatSensor hs = new HeatSensor(alarmClock, 1000,
                data -> data > 26, () -> {
            return random.nextDouble(15, 40);
        });
        ws.addObserver((data) -> System.out.println("Weight not good"));
        hs.addObserver((data) -> System.out.println("Heat not good"));

        new Thread("polling Alarm Clock Records") {
            public void run() {
                System.out.println("running clock thread ---");
                for (int i = 0; i < 60; i++) {
                    alarmClock.tic();
                    try {
                        Thread.sleep(CLOCK_INTERVAL_MILLIS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
