package at.spengergasse.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pra_practitioner")
public class Practitioner extends DomainResource {

	//Enum legt fest, welche Werte in dem Feld stehen dürfedn
	public enum Geschlecht {
		male, female, other, unknown
	}

	@Enumerated(EnumType.STRING) //EnumType legt fest, welche Datentypen in das Feld eingetragen werden dürfen
	@Column(name = "pra_geschlecht")
	Geschlecht gender;

	@Column(name = "pra_birthdate")
	LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Address.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "a_practitioner_fk", referencedColumnName = "RES_ID")
	Set<Address> address;

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Identifier.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "i_practitioner_fk", referencedColumnName = "RES_ID")
	Set<Identifier> identifiers;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = HumanName.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "h_practitioner_fk")
	Set<HumanName> names;

	@Column(name = "active")
	public Boolean active;

	public Geschlecht getGender() {
		return gender;
	}

	public void setGender(Geschlecht gender) {
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

	public Set<HumanName> getNames() {
		return names;
	}

	public void setNames(Set<HumanName> names) {
		this.names = names;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
