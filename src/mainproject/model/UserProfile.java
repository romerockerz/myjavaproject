package mainproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile implements Serializable {
	
	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", email=" + email + ", country=" + country + ", contact=" + contact
				+ ", dob=" + dob + "]";
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserProfile() {
		System.out.println("default constructor for profile object");
	}
	
	public HashMap<String, DependentProfile> getDependents() {
		return dependents;
	}
	public void setDependents(HashMap<String, DependentProfile> dependents) {
		this.dependents = dependents;
	}
	public List<MedicalHistory> getMedhistory() {
		return medhistory;
	}
	public void setMedhistory(List<MedicalHistory> medhistory) {
		this.medhistory = medhistory;
	}
	public UserProfile(String name, String email, String country, String contact, String dob, String password) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.contact = contact;
		this.dob = dob;
		this.password = password;
	}
	private static final long serialVersionUID = 1L;
	@FormParam("username")
	private String name;
	@FormParam("useremail")
	private String email;
	@FormParam("usercountry")
	private String country;
	@FormParam("usercontact")
	private String contact;
	@FormParam("userdob")
	private String dob;
	@FormParam("userpwd")
	private String password;
	public HashMap<String,DependentProfile> dependents =  new HashMap<String,DependentProfile>();
	public List<MedicalHistory> medhistory =  new ArrayList<MedicalHistory>();

	
}
