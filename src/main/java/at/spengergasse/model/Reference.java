package at.spengergasse.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reference extends Element {

	String reference;

	String type;

	@OneToOne
	Identifier identifier;

	String diaplay;

	public Reference(String reference, String type, Identifier identifier, String diaplay) {
		this.reference = reference;
		this.type = type;
		this.identifier = identifier;
		this.diaplay = diaplay;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	public String getDiaplay() {
		return diaplay;
	}

	public void setDiaplay(String diaplay) {
		this.diaplay = diaplay;
	}
}
