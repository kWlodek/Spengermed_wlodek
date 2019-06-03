package at.spengergasse.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Qualification extends BackboneElement {
    public Qualification(Set<Identifier> identifier, Set<CodeableConcept> code, Set<Period> period) { super();
        this.identifier = identifier;
        //this.code = code;
        this.period = period;
    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Identifier.class)
    @JoinColumn(name = "QUALIFICATION_FK", referencedColumnName = "RES_ID")
    private Set<Identifier> identifier = new HashSet<Identifier>();

    @Column(name = "QUALIFICATION_PERIOD")
    private Set<Period> period = new HashSet<Period>();




}
