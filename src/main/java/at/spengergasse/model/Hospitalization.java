package at.spengergasse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hospitalization extends BackboneElement {

    @OneToOne
    Identifier preAdmissionIdentifier;

    @OneToOne
    Reference origin;

    @OneToOne
    CodeableConcept admitSource;

    @OneToOne
    CodeableConcept reAdmission;

    @OneToOne
    Reference destination;

    @OneToOne
    CodeableConcept dischargeDisposition;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "dp_hospitalisation_fk", referencedColumnName = "ELEM_ID")
    Set<CodeableConcept> dietPreference;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "sc_hospitalisation_fk", referencedColumnName = "ELEM_ID")
    Set<CodeableConcept> specialCourtesy;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "sa_hospitalisation_fk", referencedColumnName = "ELEM_ID")
    Set<CodeableConcept> specialArrangement;

    public Identifier getPreAdmissionIdentifier() {
        return preAdmissionIdentifier;
    }

    public void setPreAdmissionIdentifier(Identifier preAdmissionIdentifier) { this.preAdmissionIdentifier = preAdmissionIdentifier; }

    public Reference getOrigin() {
        return origin;
    }

    public void setOrigin(Reference origin) {
        this.origin = origin;
    }

    public CodeableConcept getAdmitSource() {
        return admitSource;
    }

    public void setAdmitSource(CodeableConcept admitSource) {
        this.admitSource = admitSource;
    }

    public CodeableConcept getReAdmission() {
        return reAdmission;
    }

    public void setReAdmission(CodeableConcept reAdmission) {
        this.reAdmission = reAdmission;
    }

    public Reference getDestination() {
        return destination;
    }

    public void setDestination(Reference destination) {
        this.destination = destination;
    }

    public CodeableConcept getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setDischargeDisposition(CodeableConcept dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition;
    }

    public Set<CodeableConcept> getDietPreference() {
        return dietPreference;
    }

    public void setDietPreference(Set<CodeableConcept> dietPreference) {
        this.dietPreference = dietPreference;
    }

    public Set<CodeableConcept> getSpecialCourtesy() {
        return specialCourtesy;
    }

    public void setSpecialCourtesy(Set<CodeableConcept> specialCourtesy) {
        this.specialCourtesy = specialCourtesy;
    }

    public Set<CodeableConcept> getSpecialArrangement() {
        return specialArrangement;
    }

    public void setSpecialArrangement(Set<CodeableConcept> specialArrangement) {
        this.specialArrangement = specialArrangement;
    }
}
