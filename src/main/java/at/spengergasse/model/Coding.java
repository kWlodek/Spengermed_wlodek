package at.spengergasse.model;

import javax.persistence.Entity;

@Entity
public class Coding extends Element{


	public Coding(){
		super();
	}

	public Coding(String system, String version, String code, String display, boolean userSelected) {
		this.system = system;
		this.version = version;
		this.code = code;
		this.display = display;
		this.userSelected = userSelected;
	}

	String system;

	String version;

	String code; //Enum, wenn ValueSet bekannt ist

	String display;

	boolean userSelected;

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public boolean isUserSelected() {
		return userSelected;
	}

	public void setUserSelected(boolean userSelected) {
		this.userSelected = userSelected;
	}
}
