package at.spengergasse.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity //wichtig!
@Table(name="Patient") // optional
public class Patient extends DomainResource{


	//Enum legt fest, welche Werte in dem Feld stehen dürfen
	public enum GESCHLECHT {
		male, female, other, unknown
	}

	@Enumerated(EnumType.STRING) //EnumType legt fest, welche Datentypen in das Feld eingetragen werden dürfen
	@Column(name = "p_geschlecht") //diese Annotation ist optional
			GESCHLECHT gender;

	@Column(name = "p_birthdate") //optional
			LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "a_patient_fk", referencedColumnName = "RES_ID")
	Set<Address> address;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "i_patient_fk", referencedColumnName = "RES_ID")
	Set<Identifier> identifiers;


	public GESCHLECHT getGender() {
		return gender;
	}

	public void setGender(GESCHLECHT gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Identifier> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Set<Identifier> identifiers) {
		this.identifiers = identifiers;
	}
}
