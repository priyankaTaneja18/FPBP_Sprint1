package com.fpbp.model;

public class Donor {
	private String name;
	private String address;
	private String contactNo;
	private String email;
	private String hoursOfOperation;
	private String website;
	private String category;
	private int id;
	
	public Donor() {
		//super();
	}
	
	public Donor(String name, String address, String contactNo, String email, String hoursOfOperation,
			String website, String category, int id) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.hoursOfOperation = hoursOfOperation;
		this.website = website;
		this.category=category;
		this.id=id;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoursOfOperation() {
		return hoursOfOperation;
	}
	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
