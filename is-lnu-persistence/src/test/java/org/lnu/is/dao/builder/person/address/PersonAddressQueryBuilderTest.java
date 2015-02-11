package org.lnu.is.dao.builder.person.address;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.addresstype.AddressType;
import org.lnu.is.domain.adminunit.AdminUnit;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.person.address.PersonAddress;
import org.lnu.is.domain.streettype.StreetType;

public class PersonAddressQueryBuilderTest {

	private PersonAddressQueryBuilder unit = new PersonAddressQueryBuilder();
	
	private Boolean active = true;
	private Boolean security = true;
	
	@Before
	public void setup() {
		unit.setActive(active);
		unit.setSecurity(security);
	}
	
	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		Person person = new Person();
		AddressType addressType = new AddressType();
		AdminUnit adminUnit = new AdminUnit();
		StreetType streetType = new StreetType();
		Date begDate = new Date();
		Date endDate = new Date();
		
		PersonAddress context = new PersonAddress();
		context.setPerson(person);
		context.setAddressType(addressType);
		context.setAdminUnit(adminUnit);
		context.setStreetType(streetType);
		context.setBegDate(begDate);
		context.setEndDate(endDate);
		
		String expectedQuery = "SELECT e FROM PersonAddress e WHERE ( e.person = :person OR e.addressType = :addressType OR e.adminUnit = :adminUnit OR e.streetType =:streetType OR e.begDate <= :begDate OR e.endDate >= :endDate ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithParametersAndDisabledDefaultConstraints() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		Person person = new Person();
		AddressType addressType = new AddressType();
		AdminUnit adminUnit = new AdminUnit();
		StreetType streetType = new StreetType();
		Date begDate = new Date();
		Date endDate = new Date();
		
		PersonAddress context = new PersonAddress();
		context.setPerson(person);
		context.setAddressType(addressType);
		context.setAdminUnit(adminUnit);
		context.setStreetType(streetType);
		context.setBegDate(begDate);
		context.setEndDate(endDate);
		
		String expectedQuery = "SELECT e FROM PersonAddress e WHERE ( e.person = :person OR e.addressType = :addressType OR e.adminUnit = :adminUnit OR e.streetType =:streetType OR e.begDate <= :begDate OR e.endDate >= :endDate ) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuild() throws Exception {
		// Given
		PersonAddress context = new PersonAddress();
		
		String expectedQuery = "SELECT e FROM PersonAddress e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledSecurityConstraint() throws Exception {
		// Given
		unit.setSecurity(false);
		
		PersonAddress context = new PersonAddress();
		
		String expectedQuery = "SELECT e FROM PersonAddress e WHERE e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledStatusConstraint() throws Exception {
		// Given
		unit.setActive(false);
		PersonAddress context = new PersonAddress();
		
		String expectedQuery = "SELECT e FROM PersonAddress e WHERE e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledDefaultConstraints() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		PersonAddress context = new PersonAddress();
		
		String expectedQuery = "SELECT e FROM PersonAddress e ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
