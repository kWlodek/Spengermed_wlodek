package at.spengergasse.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Narrative {

	
	public enum ElementStatusCode {
		generated, extensions, additional, empty
	}

	
	public Narrative() {
		super();		
	}
	
	public Narrative(ElementStatusCode status, String div) {
		super();
		this.status = status;
		this.div = div;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="NARRATIVE_STATUS")
	private ElementStatusCode status;
	
	

	@Column(name="NARRATIVE_DIV")
	private String div;

	public ElementStatusCode getStatus() {
		return status;
	}

	public void setStatus(ElementStatusCode status) {
		this.status = status;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}
	
	
}
