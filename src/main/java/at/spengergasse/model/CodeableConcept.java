package at.spengergasse.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CodeableConcept extends Element{


	public CodeableConcept(){
		super();
	}

	public CodeableConcept(Set<Coding> coding, String text) {
		this.coding = coding;
		this.text = text;
	}

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Coding.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "c_CodeableConcept_fk", referencedColumnName = "ELEM_ID")
	Set<Coding> coding;

	@Column(name = "text")
	String text;

	public Set<Coding> getCoding() {
		return coding;
	}

	public void setCoding(Set<Coding> coding) {
		this.coding = coding;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
