package at.spengergasse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Participant extends BackboneElement{

    @Embedded
    Period period;

    @OneToOne
    Reference individual;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "cc_backbone_fk", referencedColumnName = "ELEM_ID")
    Set<CodeableConcept> type;


    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Reference getIndividual() {
        return individual;
    }

    public void setIndividual(Reference individual) {
        this.individual = individual;
    }

    public Set<CodeableConcept> getType() {
        return type;
    }

    public void setType(Set<CodeableConcept> type) {
        this.type = type;
    }
}
