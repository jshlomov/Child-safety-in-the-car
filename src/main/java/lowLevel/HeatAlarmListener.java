package lowLevel;

import AlarmClock.AlarmListener;

public class HeatAlarmListener implements AlarmListener {

    HeatSensor itsHeatSensor;

    public HeatAlarmListener(HeatSensor itsHeatSensor) {
        this.itsHeatSensor = itsHeatSensor;
    }

    @Override
    public void wakeup() {
        itsHeatSensor.check();
    }
}
