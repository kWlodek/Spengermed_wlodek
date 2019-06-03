package at.spengergasse.model;

import at.spengergasse.converter.AddressLineConverter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="address")
public class Address extends Element {
	
	public Address(Use use, Type type, String text, Set<String> line, String city, String district, String state,
                   String postCode, String country, Period period)
	{
		this.use = use;
		this.type = type;
		this.text = text;
		this.line = line;
		this.city = city;
		this.district = district;
		this.state = state;
		this.postalCode = postCode;
		this.country = country;
		this.period = period;
	}


	public enum Use{
		home,work,temp,old,billing
	}

	public enum Type{
		postal,physical,both
	}
	@Enumerated
	@Column(name = "a_use")
	public Use use;
	
	@Enumerated
	@Column(name="a_type")
	public Type type;
	
	@Column(name="a_text")
	public String text;
	
	
	@Column(name ="a_line")
	@Convert(converter = AddressLineConverter.class)
	public Set<String> line;
	
	@Column(name="a_city")
	public String city;
	
	@Column(name="a_district")
	public String district;
	
	@Column(name="a_state")
	public String state;
	
	@Column(name="a_postalCode")
	public String postalCode;
	
	@Column(name="a_country")
	public String country;
	
	@Embedded
	@Column(name="a_period")
	public Period period;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Patient.class, fetch= FetchType.EAGER)
	public Set<Patient> patients;
	
	public Use getUse() {
		return use;
	}

	public void setUse(Use use) {
		this.use = use;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<String> getLine() {
		return line;
	}

	public void setLine(Set<String> line) {
		this.line = line;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postalCode;
	}

	public void setPostalCode(String postCode) {
		this.postalCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
