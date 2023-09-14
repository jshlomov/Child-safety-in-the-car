package lowLevel;

import AlarmClock.AlarmClock;

public class WeightSensor extends Observable<Integer> {

    WeightSensorImp itsWeightSensorImp;
    private CheckProtocol<Integer> checkProtocol;

    public WeightSensor(AlarmClock alarmClock, int interval,  CheckProtocol<Integer> checkProtocol, WeightSensorImp weightSensorImp) {
        this.checkProtocol = checkProtocol;
        this.itsWeightSensorImp = weightSensorImp;
        alarmClock.addListener(interval, new WeightAlarmListener(this));
    }

    public void setCheckProtocol(CheckProtocol<Integer> checkProtocol) {
        this.checkProtocol = checkProtocol;
    }

    public void check() {
        Integer temp = itsWeightSensorImp.read();
        if (this.checkProtocol.check(temp)) {
            notifyObservers(temp);
        }
    }
}
