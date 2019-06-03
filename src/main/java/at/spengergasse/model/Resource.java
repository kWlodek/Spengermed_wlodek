package at.spengergasse.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Resource {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)

	@Column(name="RES_ID")
	private Long id; 
	
	@Embedded
	private Meta meta = new Meta();
	
	@Column(name="RES_LANGUAGE")
	private String language = "de-AT";

	
	public String getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
}
