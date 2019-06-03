package at.spengergasse.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "TagCoding")
@DiscriminatorValue("TagCoding")
public class TagCoding extends Coding {

	public enum TagCodingCode {
		actionable
	}

	public static final String SYSTEM_URI = "http://hl7.org/fhir/common-tags";

	@Column(name = "CODING_CODE")
	@Enumerated(EnumType.STRING)
	private TagCodingCode code;

	@Transient
	private static Map<TagCodingCode, String> tagCodesMap;

	@Transient
	protected static Map<TagCodingCode, String> codesMap;

	public TagCoding() {

		setSystem(SYSTEM_URI);

		codesMap = new HashMap<TagCodingCode, String>();
		codesMap.put(TagCodingCode.actionable, "Actionable");

	}

	@Override
	public String getCode() {
		return code.name();
	}

	public void setCode(TagCodingCode code) {
		if (codesMap.containsKey(code)) {
			this.code = code;
			this.setDisplay(codesMap.get(code));
		} else {
			try {
				throw new Exception("Meta setTag Coding invalid Code:" + code);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
