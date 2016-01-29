package business.wrapper;

public class CourtState {
    
    private int courtId;

    private boolean active;

    public CourtState() {
    }

    public CourtState(int courtId, boolean active) {
        super();
        this.courtId = courtId;
        this.active = active;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CourtStateWrapper [courtId=" + courtId + ", active=" + active + "]";
    }
    
}
