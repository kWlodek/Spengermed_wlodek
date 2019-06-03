package at.spengergasse.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.net.URI;
import java.util.Set;

@Embeddable
public abstract class Extension<T> {

	
	@Column(name="EX_URL")
	private URI url;
	
	@Column(name="EX_VALUE")
	private Set<T> value;


	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}

	public Set<T> getValue() {
		return value;
	}

	public void setValue(Set<T> value) {
		this.value = value;
	}
	
	
	
}
