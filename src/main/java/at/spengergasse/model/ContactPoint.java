package at.spengergasse.model;

import javax.persistence.*;

public class ContactPoint implements java.io.Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public enum ContactPointSystemCode {
		phone, fax, email, pager, url, sms, other
	}

	public enum ContactPointUseCode {
		home, work, temp, old, mobile
	}

	public ContactPoint() {
		super();
	};

	public ContactPoint(ContactPointSystemCode system, String value, ContactPointUseCode use, int rank, Period period) {
		super();
		this.system = system;
		this.value = value;
		this.use = use;
		this.rank = rank;
		this.period = period;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CP_SYSTEM")
	private ContactPointSystemCode system;

	@Column(name = "CP_VALUE")
	private String value;

	@Enumerated(EnumType.STRING)
	@Column(name = "CP_USE")
	private ContactPointUseCode use;

	@Column(name = "CP_RANK")
	private int rank;

	@Embedded
	@Column(name = "CP_PERIOD")
	private Period period;


	public ContactPointSystemCode getSystem() {
		return system;
	}

	public void setSystem(ContactPointSystemCode system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ContactPointUseCode getUse() {
		return use;
	}

	public void setUse(ContactPointUseCode use) {
		this.use = use;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

}
