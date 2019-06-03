package at.spengergasse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Observation extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "i_observation_fk", referencedColumnName = "RES_ID")
    Set<Identifier> identifiers;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Reference.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "partOf_observation_fk", referencedColumnName = "RES_ID")
    Set<Reference> partOf;

    @OneToOne
    Reference status;

    @OneToOne
    CodeableConcept code;

    @OneToOne
    Reference subject;

    //Contructors

    public Set<Identifier> getIdentifiers() { return identifiers; }

    public void setIdentifiers(Set<Identifier> identifiers) { this.identifiers = identifiers; }

    public Set<Reference> getPartOf() { return partOf; }

    public void setPartOf(Set<Reference> partOf) { this.partOf = partOf; }

    public Reference getStatus() {
        return status;
    }

    public void setStatus(Reference status) {
        this.status = status;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public Reference getSubject() { return subject; }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }
}
