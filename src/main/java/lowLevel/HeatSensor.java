package lowLevel;

import AlarmClock.AlarmClock;

public class HeatSensor extends Observable<Double> {
    HeatSensorImp itsHeatSensorImp;
    private CheckProtocol<Double> checkProtocol;

    public HeatSensor(AlarmClock alarmClock, int interval, CheckProtocol<Double> checkProtocol, HeatSensorImp heatSensorImp) {
        this.checkProtocol = checkProtocol;
        this.itsHeatSensorImp = heatSensorImp;
        alarmClock.addListener(interval, new HeatAlarmListener(this));
    }

    public void setCheckProtocol(CheckProtocol<Double> checkProtocol) {
        this.checkProtocol = checkProtocol;
    }

    public void check() {
        Double temp = itsHeatSensorImp.read();
        if(this.checkProtocol.check(temp)) {
            notifyObservers(temp);
        }
    }
}
