package mainproject.model;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import javax.ws.rs.FormParam;


@XmlRootElement
public class MedicalHistory implements Serializable{

	private static final long serialVersionUID = 3063367434328929346L;
	@FormParam("useremail")
	private String useremail;
	@FormParam("relation")
	private String relation;
	@FormParam("illness")
	private String illness;
	@FormParam("doctorname")
	private String doctorName;
	@FormParam("medicine")
	private String medicine;
	@FormParam("startdate")
	private String startDate;
	@FormParam("enddate")
	private String endDate;
	@FormParam("dosage")
	private String dosage;
	@FormParam("dosagefreq")
	private String dosageFrequency;
	@FormParam("dosagetime")
	private String dosageTime;
	
	public MedicalHistory() {
		super();
	}
	public MedicalHistory(String useremail, String relation, String illness, String doctorName, String medicine,
			String startDate, String endDate, String dosage, String dosageFrequency, String dosageTime) {
		super();
		this.useremail = useremail;
		this.relation = relation;
		this.illness = illness;
		this.doctorName = doctorName;
		this.medicine = medicine;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dosage = dosage;
		this.dosageFrequency = dosageFrequency;
		this.dosageTime = dosageTime;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getDosageFrequency() {
		return dosageFrequency;
	}
	public void setDosageFrequency(String dosageFrequency) {
		this.dosageFrequency = dosageFrequency;
	}
	public String getDosageTime() {
		return dosageTime;
	}
	public void setDosageTime(String dosageTime) {
		this.dosageTime = dosageTime;
	}

	@Override
	public String toString() {
		return "MedicalHistory [useremail=" + useremail + ", relation=" + relation + ", illness=" + illness
				+ ", doctorName=" + doctorName + ", medicine=" + medicine + ", startDate=" + startDate + ", endDate="
				+ endDate + ", dosage=" + dosage + ", dosageFrequency=" + dosageFrequency + ", dosageTime=" + dosageTime
				+ "]";
	}
	
	
	
}
