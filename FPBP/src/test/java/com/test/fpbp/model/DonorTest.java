package com.test.fpbp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fpbp.model.Donor;

public class DonorTest {
	
	@Test
	public void testDonorConstructor() {
		Donor d=new Donor("UNCC","Charlotte","980980","uncc@unn.edu","5Days","","Food",1);
		assertEquals(d.getName(),"UNCC");
		assertEquals(d.getAddress(),"Charlotte");
		assertEquals(d.getContactNo(),"980980");
		assertEquals(d.getEmail(),"uncc@unn.edu");
		assertEquals(d.getHoursOfOperation(),"5Days");
		assertEquals(d.getWebsite(),"");
		assertEquals(d.getCategory(),"Food");
	}
	
	@Test
	public void testGetterSetters() {
		Donor d=new Donor();
		d.setName("UNCC");
		d.setAddress("Charlotte");
		d.setContactNo("980980");
		d.setEmail("uncc@unn.edu");
		d.setHoursOfOperation("5Days");
		d.setWebsite("");
		d.setCategory("Food");
		assertEquals(d.getName(),"UNCC");
		assertEquals(d.getAddress(),"Charlotte");
		assertEquals(d.getContactNo(),"980980");
		assertEquals(d.getEmail(),"uncc@unn.edu");
		assertEquals(d.getHoursOfOperation(),"5Days");
		assertEquals(d.getWebsite(),"");
		assertEquals(d.getCategory(),"Food");
	}
}
