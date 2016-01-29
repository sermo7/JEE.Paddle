package business.wrapper;

import java.util.Calendar;
import java.util.List;

public class Availability {
    private Calendar day;

    private List<AvailableTime> times;

    public Availability() {
    }

    public Availability(Calendar day, List<AvailableTime> times) {
        this.day = day;
        this.times = times;
    }

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }

    public List<AvailableTime> getTimes() {
        return times;
    }

    public void setTimes(List<AvailableTime> times) {
        this.times = times;
    }

}
