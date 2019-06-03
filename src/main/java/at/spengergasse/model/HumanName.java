package at.spengergasse.model;

import at.spengergasse.converter.AddressLineConverter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "h_humanName")
public class HumanName extends Element {

	public enum Use{
		usual, official , temp , nickname , anonymous , old , maiden
	}

	public HumanName(Use use, String text, String family, Set<String> given, Set<String> prefix, Set<String> suffix, Period period) {
		this.use = use;
		this.text = text;
		this.family = family;
		this.given = given;
		this.prefix = prefix;
		this.suffix = suffix;
		this.period = period;
	}

	@Enumerated
	@Column(name = "h_use")
	public Use use;

	public String text;
	public String family;
	@Convert(converter = AddressLineConverter.class) //selber Converter we in Address, aber ich denke das macht keinen Unterschied
	public Set<String> given;
	@Convert(converter = AddressLineConverter.class)
	public Set<String> prefix;
	@Convert(converter = AddressLineConverter.class)
	public Set<String> suffix;

	@Embedded
	public Period period;


	public Use getUse() {
		return use;
	}

	public void setUse(Use use) {
		this.use = use;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Set<String> getGiven() {
		return given;
	}

	public void setGiven(Set<String> given) {
		this.given = given;
	}

	public Set<String> getPrefix() {
		return prefix;
	}

	public void setPrefix(Set<String> prefix) {
		this.prefix = prefix;
	}

	public Set<String> getSuffix() {
		return suffix;
	}

	public void setSuffix(Set<String> suffix) {
		this.suffix = suffix;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
