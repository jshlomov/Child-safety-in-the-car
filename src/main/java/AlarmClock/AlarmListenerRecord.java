package AlarmClock;

public class AlarmListenerRecord {
    int interval;
    int remainingTime;
    AlarmListener alarmListener;

    public AlarmListenerRecord(int interval, AlarmListener alarmListener) {
        this.remainingTime = this.interval = interval;
        this.alarmListener = alarmListener;
    }

    public void decrementRemainingTime(int clockIntervalMillis) {
        this.remainingTime -= clockIntervalMillis;
    }


    /////////Getters

    public int getInterval() {
        return interval;
    }

    @SuppressWarnings("unused")
    public int getRemainingTime() {
        return remainingTime;
    }

    public AlarmListener getAlarmListener() {
        return alarmListener;
    }

    /////////setters

    @SuppressWarnings("unused")
    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @SuppressWarnings("unused")
    public void setAlarmListener(AlarmListener alarmListener) {
        this.alarmListener = alarmListener;
    }

}
