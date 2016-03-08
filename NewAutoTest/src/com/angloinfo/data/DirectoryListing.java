package com.angloinfo.data;

import com.angloinfo.tools.minMaxRandom;

public class DirectoryListing {
		private String location;
		private String parent_id;
		private String category_id;
		private String name;
		private String description;
		private String address;
		private float longtitude;
		private float latitude;
		private String contact_number;
		private String contact_email;
		private String contact_website;
		
				public DirectoryListing() {
					int serial = minMaxRandom.generate(9999, 1);
					setLocation("algrave");
					setCategory_id("15039");
					setName("ainfo"+ serial);
					setDescription("desc" + serial);
					setAddress("address" +serial);
					setLongtitude(0);
					setLatitude(0);
					setContact_number("777");
					setContact_email("ainfo" + serial + "@gmail.com");
					setContact_website("www" + serial + ".com");
					setParent_id("null");
					
					
				}

				public String getAddress() {
					return address;
				}

				private void setAddress(String address) {
					this.address = address;
				}

				public String getCategory_id() {
					return category_id;
				}

				private void setCategory_id(String category_id) {
					this.category_id = category_id;
				}

				public String getContact_email() {
					return contact_email;
				}

				private void setContact_email(String contact_email) {
					this.contact_email = contact_email;
				}

				public String getContact_website() {
					return contact_website;
				}

				private void setContact_website(String contact_website) {
					this.contact_website = contact_website;
				}

				public String getDescription() {
					return description;
				}

				private void setDescription(String description) {
					this.description = description;
				}

				public float getLatitude() {
					return latitude;
				}

				private void setLatitude(float latitude) {
					this.latitude = latitude;
				}

				public String getLocation() {
					return location;
				}

				private void setLocation(String location) {
					this.location = location;
				}

				public float getLongtitude() {
					return longtitude;
				}

				private void setLongtitude(float longtitude) {
					this.longtitude = longtitude;
				}

				public String getName() {
					return name;
				}

				private void setName(String name) {
					this.name = name;
				}

				public String getParent_id() {
					return parent_id;
				}

				private void setParent_id(String parent_id) {
					this.parent_id = parent_id;
				}

				public String getContact_number() {
					return contact_number;
				}

				private void setContact_number(String contact_number) {
					this.contact_number = contact_number;
				}
				
}
