package lowLevel;

import AlarmClock.AlarmListener;

public class WeightAlarmListener implements AlarmListener {

    WeightSensor itsWeightSensor;
    public WeightAlarmListener(WeightSensor weightSensor) {
        this.itsWeightSensor = weightSensor;
    }

    @Override
    public void wakeup() {
        itsWeightSensor.check();
    }
}
