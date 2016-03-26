package data.entities;

import java.text.SimpleDateFormat;
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
    private List<User> users;
    
    public Training(Court court, User trainer, Calendar sdate, Calendar fdate, List<User> users) {
        this.court = court;
        this.trainer = trainer;
        this.startDate = sdate;
        this.finishDate = fdate;
        this.users = users;
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


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
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
        return "Training [id=" + id + ", courtId=" + court.getId() + ", startDate=" + startDate + ", finishDate=" + finishDate + ", trainer=" + trainer + ", + users=" + users + "]";
    }

}
