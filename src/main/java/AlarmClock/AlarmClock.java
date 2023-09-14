package AlarmClock;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class AlarmClock {
    private int ticUnit = 100;
    ArrayList<AlarmListenerRecord> itsAlarmListenerRecords = new ArrayList<>();
    @Inject
    public AlarmClock() {}

    public void addListener(int interval, AlarmListener alarmListener) {
        itsAlarmListenerRecords.add(new AlarmListenerRecord(interval, alarmListener));
    }

    public void tic() {
        for (AlarmListenerRecord record : itsAlarmListenerRecords) {
            if (record.remainingTime - ticUnit <= 0) {
                record.getAlarmListener().wakeup();
                record.setRemainingTime(record.getInterval());
            } else
                record.decrementRemainingTime(ticUnit);
        }
    }

    public int getTicUnit() {
        return ticUnit;
    }

    public void setTicUnit(int ticUnit) {
        this.ticUnit = ticUnit;
    }
}
