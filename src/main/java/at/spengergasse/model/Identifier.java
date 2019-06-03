package at.spengergasse.model;

import javax.persistence.*;

@Entity
public class Identifier extends Element {

	public Identifier(Use use, CodeableConcept type, String system, String value, Period period) {
		this.use = use;
		this.type = type;
		this.system = system;
		this.value = value;
		this.period = period;
	}

	public enum Use {
		usual, official, temp, secondary, old
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "i_use")
	public Use use;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "c_identifier_fk", nullable = true, insertable = true, updatable = true)
	CodeableConcept type;

	String system;

	@Column(name = "i_value")
	String value;

	@Embedded
	Period period;

	public Use getUse() {
		return use;
	}

	public void setUse(Use use) {
		this.use = use;
	}

	public CodeableConcept getType() {
		return type;
	}

	public void setType(CodeableConcept type) {
		this.type = type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
