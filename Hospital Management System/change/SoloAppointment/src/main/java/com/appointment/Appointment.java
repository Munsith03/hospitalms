package com.appointment;

public class Appointment {
	 // ENCAPSULATION (private fields)
	private int id;
    private String patientName;
    private String patientAge;
    private String gender;
    private String contactNumber;
    private String email;
    private String doctorName;
    private String specialization;
    private String appointmentDate;
    private String reasonForVisit;
    
    // CONSTRUCTOR (object initialization)
    // Method for creating instances with initial state
	public Appointment(int id, String patientName, String patientAge, String gender, String contactNumber, String email,
			String doctorName, String specialization, String appointmentDate, String reasonForVisit) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.appointmentDate = appointmentDate;
		this.reasonForVisit = reasonForVisit;
	}
	
	// ACCESSORS/MUTATORS (getters/setters)
    // Controlled access to encapsulated data
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getReasonForVisit() {
		return reasonForVisit;
	}
	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}
    
    


}
