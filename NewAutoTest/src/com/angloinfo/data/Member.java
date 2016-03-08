package com.angloinfo.data;
import com.angloinfo.tools.*;

public class Member {
	
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String gender;
	private String password;
	private String location;
	private int Max;
	private int Min;
	
		
		public Member() {
		
			int serial = minMaxRandom.generate(9999,1);
			
			setFirstname("afirst" + Integer.toString(serial));
			setLastname("alast" + Integer.toString(serial));
			setEmail("ainfo1001" + "+" + Integer.toString(serial) + "@gmail.com");
			setPassword("Anglo123");
			setUsername("ainfo1001" + "+" + Integer.toString(serial));
			setGender("Male");
			setLocation("algarve");
			
			
}


		public String getPassword() {
			return password;
		}


		void setPassword(String password) {
			this.password = password;
		}


		public String getLocation() {
			return location;
		}


		void setLocation(String location) {
			this.location = location;
		}


		int getMax() {
			return Max;
		}


		void setMax(int max) {
			Max = max;
		}


		int getMin() {
			return Min;
		}


		void setMin(int min) {
			Min = min;
		}


		public String getLastname() {
			return lastname;
		}


		void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public String getFirstname() {
			return firstname;
		}


		void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getEmail() {
			return email;
		}


		void setEmail(String email) {
			this.email = email;
		}


		public String getUsername() {
			return username;
		}


		void setUsername(String username) {
			this.username = username;
		}


		public String getGender() {
			return gender;
		}


		void setGender(String gender) {
			this.gender = gender;
		}
}