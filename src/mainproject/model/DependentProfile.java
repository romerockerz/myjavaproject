package mainproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DependentProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	@FormParam("relation")
	private String relationship;
	@FormParam("name")
	private String name;
	@FormParam("email")
	private String email;
	@FormParam("contact")
	private String contact;
	@FormParam("dob")
	private String dob;
	@FormParam("useremail")
	private String headuserid;
	
	public String getHeaduserid() {
		return headuserid;
	}

	public void setHeaduserid(String headuserid) {
		this.headuserid = headuserid;
	}

	public List<MedicalHistory> medhistory =  new ArrayList<MedicalHistory>();
	
	public DependentProfile(String headuserid, String relationship, String name, String email, String contact, String dob) {
		super();
		this.headuserid=headuserid;
		this.relationship = relationship;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
	}
	
	
	public DependentProfile() {
		super();
		
	}

	public List<MedicalHistory> getMedhistory() {
		return medhistory;
	}

	public void setMedhistory(List<MedicalHistory> medhistory) {
		this.medhistory = medhistory;
	}

	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "DependentProfile [headuserid=" + headuserid + "relationship=" + relationship + ", name=" + name + ", email=" + email + ", contact="
				+ contact + ", dob=" + dob + " ]";
	}
	
	
}
