package business.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reserve {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Court court;

    private Calendar date;

    public Reserve(Court court, Calendar date) {
        super();
        this.court = court;
        this.date = date;
    }

    public Reserve() {
    }

    public int getId() {
        return id;
    }

    public Court getCourt() {
        return court;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            Reserve other = (Reserve) obj;
            return id == other.id;
        }
    }

    @Override
    public String toString() {
        String time = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(date.getTime());
        return "Reserve [id=" + id + ", courtId=" + court.getId() + ", date=" + time + "]";
    }

}
