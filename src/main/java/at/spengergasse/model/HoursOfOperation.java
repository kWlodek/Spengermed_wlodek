package at.spengergasse.model;

import org.aspectj.apache.bcel.classfile.Code;

import javax.persistence.*;
import java.sql.Time;

public class HoursOfOperation extends BackboneElement {

    public HoursOfOperation(Code daysOfWeek, boolean allDay, Time openingTime){
        super();
        this.allDay = allDay;
        this.daysOfWeek = daysOfWeek;
        this.openingTime = openingTime;
    }

    @OneToOne
    boolean allDay;

    @OneToOne
    Time openingTime;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Code.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "code_hoo_fk", referencedColumnName = "RES_ID")
    Code daysOfWeek;

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public Code getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(Code daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}
