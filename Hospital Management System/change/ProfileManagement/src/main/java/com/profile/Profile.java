package com.profile;

public class Profile {
	// ENCAPSULATION (private fields)
	 private int id;
	    private String uname;
	    private String dob;
	    private String address;
	    private String email;
	    private String cnumber;
	    private String type;
	    private String password;
	    
		public Profile(int id, String uname, String dob, String address, String email, String cnumber, String type,
				String password) {
			super();
			this.id = id;
			this.uname = uname;
			this.dob = dob;
			this.address = address;
			this.email = email;
			this.cnumber = cnumber;
			this.type = type;
			this.password = password;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCnumber() {
			return cnumber;
		}

		public void setCnumber(String cnumber) {
			this.cnumber = cnumber;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	    
}