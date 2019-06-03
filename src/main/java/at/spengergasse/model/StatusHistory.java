package at.spengergasse.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class StatusHistory extends BackboneElement {

    String status;

    @Embedded
    Period period;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
