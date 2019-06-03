package at.spengergasse.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
public class ClassHistory extends BackboneElement
{
    @OneToOne
    Coding chClass;

    @Enumerated
    Period period;

    public Coding getChClass() {
        return chClass;
    }

    public void setChClass(Coding chClass) {
        this.chClass = chClass;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
