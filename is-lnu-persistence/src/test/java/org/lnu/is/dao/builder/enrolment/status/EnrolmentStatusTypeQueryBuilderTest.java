package org.lnu.is.dao.builder.enrolment.status;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.enrolment.EnrolmentStatusType;

public class EnrolmentStatusTypeQueryBuilderTest {

	private EnrolmentStatusTypeQueryBuilder unit = new EnrolmentStatusTypeQueryBuilder();
	
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
		EnrolmentStatusType context = new EnrolmentStatusType();
		
		String expectedQuery = "SELECT e FROM EnrolmentStatusType e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String abbrName = "abbrname";
		String name = "nasfads";
		
		EnrolmentStatusType context = new EnrolmentStatusType();
		context.setAbbrName(abbrName);
		context.setName(name);

		String expectedQuery = "SELECT e FROM EnrolmentStatusType e WHERE ( e.abbrName LIKE CONCAT('%',:abbrName,'%') OR e.name LIKE CONCAT('%',:name,'%') ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	
}
