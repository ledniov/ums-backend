package org.lnu.is.dao.builder.person;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.marriedtype.MarriedType;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.person.type.PersonType;

public class PersonQueryBuilderTest {

	private PersonQueryBuilder unit = new PersonQueryBuilder();
	
	private Boolean active = true;
	private Boolean security = true;
	
	@Before
	public void setup() {
		unit.setActive(active);
		unit.setSecurity(security);
	}

	@Test
	public void testBuild() throws Exception {
		// Given
		Person context = new Person();
		
		String expectedQuery = "SELECT e FROM Person e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledSecurityConstraint() throws Exception {
		// Given
		unit.setSecurity(false);
		Person context = new Person();
		
		String expectedQuery = "SELECT e FROM Person e WHERE e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledStatusConstraint() throws Exception {
		// Given
		unit.setActive(false);
		Person context = new Person();
		
		String expectedQuery = "SELECT e FROM Person e WHERE e.crtUserGroup IN (:userGroups) ";
		
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
		
		Person context = new Person();
		
		String expectedQuery = "SELECT e FROM Person e ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String name = "name";
		PersonType personType = new PersonType();
		String surname = "fdsfd";
		String docNum = "fsdfds";
		MarriedType marriedType = new MarriedType();

		Person context = new Person();
		context.setName(name);
		context.setPersonType(personType);
		context.setMarriedType(marriedType);
		context.setSurname(surname);
		context.setDocNum(docNum);

		String expectedQuery = "SELECT e FROM Person e WHERE ( e.personType = :personType OR e.marriedType = :marriedType OR e.name LIKE CONCAT('%',:name,'%') OR e.surname LIKE CONCAT('%',:surname,'%') OR e.docNum LIKE CONCAT('%',:docNum,'%') ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
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
		
		String name = "name";
		PersonType personType = new PersonType();
		String surname = "fdsfd";
		String docNum = "fsdfds";
		MarriedType marriedType = new MarriedType();
		
		Person context = new Person();
		context.setName(name);
		context.setPersonType(personType);
		context.setMarriedType(marriedType);
		context.setSurname(surname);
		context.setDocNum(docNum);
		
		String expectedQuery = "SELECT e FROM Person e WHERE ( e.personType = :personType OR e.marriedType = :marriedType OR e.name LIKE CONCAT('%',:name,'%') OR e.surname LIKE CONCAT('%',:surname,'%') OR e.docNum LIKE CONCAT('%',:docNum,'%') ) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
