package at.spengergasse.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DomainResource extends Resource {

	public DomainResource() {
		super();
	};

	public DomainResource(Narrative text) {
		super();
		this.text = text;
	}


	@Embedded
	private Narrative text;

	public Narrative getText() {
		return text;
	}

	public void setText(Narrative text) {
		this.text = text;
	}

}
