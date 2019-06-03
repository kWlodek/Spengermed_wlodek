package at.spengergasse.model;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class Meta {

	public Meta() {};
	
	public Meta(Integer versionId, LocalDateTime lastUpdated, Set<Coding> security) {
		super();
		this.versionId = versionId;
		this.lastUpdated = lastUpdated;
		this.security = security;
	}

	
	@Column(name="META_VERSIONID")
	private Integer versionId=0;
	
	@Column(name="META_LASTUPDATED")
	@LastModifiedDate
	private LocalDateTime lastUpdated;


	@OneToMany(  cascade = {CascadeType.MERGE, CascadeType.REFRESH}
		,orphanRemoval = true
		,targetEntity = Coding.class
    )
	@JoinTable(
	    name="META_CODING",
	    joinColumns = @JoinColumn( name="META_RES_ID"),
	    inverseJoinColumns = @JoinColumn( name="CODING_ELEM_ID")
	)	
	private Set<Coding> security = new HashSet<Coding>();

	
	private String getVersionId() {
		return ""+versionId;
	}
	public void setVersionId(String versionIdI) {
		this.versionId = Integer.valueOf(versionIdI);
	}
	public Set<Coding> getSecurity() {
		return security;
	}
	public void setSecurity(Set<Coding> security) {
		this.security = security;
	}
	
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public String getNextVersionId() {
		
		return ((getVersionId() == null) ? "0" : ""+(getVersionId()+1));		
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	
}
