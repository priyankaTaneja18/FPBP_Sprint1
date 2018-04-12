package com.test.fpbp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;

public class SeekerTest {
	
	@Test
	public void testSeekerConstructor() {
		Seeker d=new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food");
		assertEquals(d.getOrgName(),"UNCCOrg");
		assertEquals(d.getAddress(),"Charlotte");
		assertEquals(d.getContactNo(),"980980");
		assertEquals(d.getEmail(),"uncc@uncc.edu");
		assertEquals(d.getWebsite(),"uncc.com");
		assertEquals(d.getRequirement(),"Food");
		assertEquals(d.getCategory(),"Food");
		assertEquals(d.getQuantity(),50);
	}
	
	@Test
	public void testGetterSetters() {
		Seeker d=new Seeker();
		d.setOrgName("UNCCOrg");
		d.setAddress("Charlotte");
		d.setContactNo("980980");
		d.setEmail("uncc@unn.edu");
		d.setQuantity(50);
		d.setCategory("Food");
		d.setWebsite("uncc.com");
		d.setRequirement("Food");
		assertEquals(d.getOrgName(),"UNCCOrg");
		assertEquals(d.getAddress(),"Charlotte");
		assertEquals(d.getContactNo(),"980980");
		assertEquals(d.getEmail(),"uncc@unn.edu");
		assertEquals(d.getWebsite(),"uncc.com");
		assertEquals(d.getRequirement(),"Food");
		assertEquals(d.getCategory(),"Food");
		assertEquals(d.getQuantity(),50);
	}

}
