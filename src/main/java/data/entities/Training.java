package data.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Training {

	public static final int MAX_PUPILS = 4;
	public static final int TRAINING_MINUTES_TIME = 60;
		
    @Id
    @GeneratedValue
    private int id;
    
    private Calendar startDate;
    
    private Calendar finishDate;

    @ManyToOne
    @JoinColumn
    private Court court;

    @ManyToOne
    @JoinColumn
    private User trainer;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> pupils;
    
    public Training(Court court, User trainer, Calendar sdate, Calendar fdate, List<User> pupils) {
        this.court = court;
        this.trainer = trainer;
        this.startDate = sdate;
        this.finishDate = fdate;
        this.pupils = pupils;
    }
    
    public Training(Court court, User trainer, Calendar sdate, Calendar fdate) {
        this.court = court;
        this.trainer = trainer;
        this.startDate = sdate;
        this.finishDate = fdate;
        this.pupils = new ArrayList<User>();
    }
    
    public Training(Court court, User trainer, Calendar sdate) {
        this.court = court;
        this.trainer = trainer;
        this.startDate = sdate;
        this.finishDate = addTimeTraining(sdate);
        this.pupils = new ArrayList<User>();
    }
    
    
    public static Calendar addTimeTraining(Calendar sDate){
    	Calendar fDate = sDate;
    	fDate.add(Calendar.MINUTE, TRAINING_MINUTES_TIME);
    	return fDate;
    }



    public List<User> getPupils() {
		return pupils;
	}

	public void setPupils(List<User> pupils) {
		this.pupils = pupils;
	}

	public Training() {
    }

    public int getId() {
        return id;
    }

    public Court getCourt() {
        return court;
    }



    public Calendar getStartDate() {
		return startDate;
	}


	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}


	public Calendar getFinishDate() {
		return finishDate;
	}


	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}


	public User getTrainer() {
		return trainer;
	}


	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}


	@Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Training) obj).id;
    }

    @Override
    public String toString() {
    	String startDateFormatString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.getStartDate().getTime());
    	String finishDateFormatString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.getFinishDate().getTime());
        return "Training [id=" + id + ", courtId=" + court.getId() + ", startDate=" + startDateFormatString + ", finishDate=" + finishDateFormatString + ", trainer=" + trainer + ", pupils=" + pupils + "]";
    }

}
