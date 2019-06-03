package at.spengergasse.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Period {

	public Period(){
		super();
	}

	public Period(LocalDate start, LocalDate end) {
		this.start = start;
		this.end = end;
	}

	@Column(name = "peroid_start")
	LocalDate start;

	@Column(name = "peroid_end")
	LocalDate end;

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}
}
