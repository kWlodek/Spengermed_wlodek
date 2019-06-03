package at.spengergasse.model;


import org.aspectj.apache.bcel.classfile.Code;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Location")
public class Location extends DomainResource{


public Location(Coding operationStatus, Code mode, CodeableConcept physicalType, Reference partOf, Set<HoursOfOperation> hoo){
    super();
    this.hoo = hoo;
    this.mode = mode;
    this.operationStatus = operationStatus;
    this.partOf = partOf;
    this.physicalType = physicalType;

}


    @OneToOne
    Coding operationStatus;

    @OneToOne
    Code mode;

    @OneToOne
    CodeableConcept physicalType;

    @OneToOne
    Reference partOf;

    @OneToMany(cascade=CascadeType.ALL,targetEntity= Name.class,fetch=FetchType.EAGER)
    @JoinColumn(name="hoo_location_fk",referencedColumnName="RES_ID")
    Set<HoursOfOperation> hoo;


    public Coding getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Coding operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Code getMode() {
        return mode;
    }

    public void setMode(Code mode) {
        this.mode = mode;
    }

    public CodeableConcept getPhysicalType() {
        return physicalType;
    }

    public void setPhysicalType(CodeableConcept physicalType) {
        this.physicalType = physicalType;
    }

    public Reference getPartOf() {
        return partOf;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public Set<HoursOfOperation> getHoo() {
        return hoo;
    }

    public void setHoo(Set<HoursOfOperation> hoo) {
        this.hoo = hoo;
    }
}
