package at.spengergasse.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Diagnosis extends BackboneElement {

    @OneToOne
    Reference condition;

    @OneToOne
    CodeableConcept use;

    int rank;

    public Reference getCondition() {
        return condition;
    }

    public void setCondition(Reference condition) {
        this.condition = condition;
    }

    public CodeableConcept getUse() {
        return use;
    }

    public void setUse(CodeableConcept use) {
        this.use = use;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
