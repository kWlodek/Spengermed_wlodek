package at.spengergasse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Encounter extends DomainResource {

    String status;

    @Embedded
    Period period;

    @OneToOne
    Coding eclass;

    @OneToOne
    CodeableConcept serviceType;

    @OneToOne
    CodeableConcept priority;

    @OneToOne
    Reference subject;

    String length;

    @OneToOne
    Reference serviceProvider;

    @OneToOne
    Reference partOf;

    @OneToOne
    Hospitalization hospitalization;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "i_encounter_fk", referencedColumnName = "RES_ID")
    Set<Identifier> identifier;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = StatusHistory.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "sh_encounter_fk", referencedColumnName = "RES_ID")
    Set<StatusHistory> statusHistory;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = ClassHistory.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "ch_encounter_fk", referencedColumnName = "RES_ID")
    Set<ClassHistory> classHistory;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "cc_encounter_fk", referencedColumnName = "RES_ID")
    Set<CodeableConcept> type;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Reference.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "eoc_encounter_fk", referencedColumnName = "RES_ID")
    Set<Reference> episodeOfCare;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Reference.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "bo_encounter_fk", referencedColumnName = "RES_ID")
    Set<Reference> basedOn;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Participant.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "par_encounter_fk", referencedColumnName = "RES_ID")
    Set<Participant> participants;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Reference.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "ap_encounter_fk", referencedColumnName = "RES_ID")
    Set<Reference> appointment;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "rc_encounter_fk", referencedColumnName = "RES_ID")
    Set<CodeableConcept> reasonCode;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = CodeableConcept.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "rr_encounter_fk", referencedColumnName = "RES_ID")
    Set<CodeableConcept> reasonReference;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Diagnosis.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "dia_encounter_fk", referencedColumnName = "RES_ID")
    Set<Diagnosis> diagnoses;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Reference.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_encounter_fk", referencedColumnName = "RES_ID")
    Set<Reference> account;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Location.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "lo_encounter_fk", referencedColumnName = "RES_ID")
    Set<Location> locations;

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

    public Coding getEclass() {
        return eclass;
    }

    public void setEclass(Coding eclass) {
        this.eclass = eclass;
    }

    public CodeableConcept getServiceType() {
        return serviceType;
    }

    public void setServiceType(CodeableConcept serviceType) {
        this.serviceType = serviceType;
    }

    public CodeableConcept getPriority() {
        return priority;
    }

    public void setPriority(CodeableConcept priority) {
        this.priority = priority;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Reference getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(Reference serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Reference getPartOf() {
        return partOf;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public Set<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Set<Identifier> identifier) {
        this.identifier = identifier;
    }

    public Set<StatusHistory> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(Set<StatusHistory> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public Set<ClassHistory> getClassHistory() {
        return classHistory;
    }

    public void setClassHistory(Set<ClassHistory> classHistory) {
        this.classHistory = classHistory;
    }

    public Set<CodeableConcept> getType() {
        return type;
    }

    public void setType(Set<CodeableConcept> type) {
        this.type = type;
    }

    public Set<Reference> getEpisodeOfCare() {
        return episodeOfCare;
    }

    public void setEpisodeOfCare(Set<Reference> episodeOfCare) {
        this.episodeOfCare = episodeOfCare;
    }

    public Set<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(Set<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Set<Reference> getAppointment() {
        return appointment;
    }

    public void setAppointment(Set<Reference> appointment) {
        this.appointment = appointment;
    }

    public Set<CodeableConcept> getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Set<CodeableConcept> reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Set<CodeableConcept> getReasonReference() {
        return reasonReference;
    }

    public void setReasonReference(Set<CodeableConcept> reasonReference) {
        this.reasonReference = reasonReference;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<Reference> getAccount() {
        return account;
    }

    public void setAccount(Set<Reference> account) {
        this.account = account;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
