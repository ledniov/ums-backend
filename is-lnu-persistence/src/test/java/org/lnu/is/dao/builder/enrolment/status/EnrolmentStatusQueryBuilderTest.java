package org.lnu.is.dao.builder.enrolment.status;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.enrolment.Enrolment;
import org.lnu.is.domain.enrolment.status.EnrolmentStatus;
import org.lnu.is.domain.enrolment.statustype.EnrolmentStatusType;
import org.lnu.is.domain.specoffer.SpecOfferWave;

public class EnrolmentStatusQueryBuilderTest {

	private EnrolmentStatusQueryBuilder unit = new EnrolmentStatusQueryBuilder();
	
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
		EnrolmentStatus context = new EnrolmentStatus();
		
		String expectedQuery = "SELECT e FROM EnrolmentStatus e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	
	
	@Test
	public void testBuildWithDisabledSecurityConstraitns() throws Exception {
		// Given
		unit.setSecurity(false);
		
		EnrolmentStatus context = new EnrolmentStatus();
		
		String expectedQuery = "SELECT e FROM EnrolmentStatus e WHERE e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	
	
	@Test
	public void testBuildWithDisabledStatusConstraint() throws Exception {
		// Given
		unit.setActive(false);
		
		EnrolmentStatus context = new EnrolmentStatus();
		
		String expectedQuery = "SELECT e FROM EnrolmentStatus e WHERE e.crtUserGroup IN (:userGroups) ";
		
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
		
		EnrolmentStatus context = new EnrolmentStatus();
		
		String expectedQuery = "SELECT e FROM EnrolmentStatus e ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		Enrolment enrolment = new Enrolment();
		SpecOfferWave specOfferWave = new SpecOfferWave();
		EnrolmentStatusType enrolmentStatusType = new EnrolmentStatusType();
		
		EnrolmentStatus context = new EnrolmentStatus();
		context.setEnrolment(enrolment);
		context.setSpecOfferWave(specOfferWave);
		context.setEnrolmentStatusType(enrolmentStatusType);

		String expectedQuery = "SELECT e FROM EnrolmentStatus e WHERE ( e.enrolment = :enrolment OR e.specOfferWave =:specOfferWave OR e.enrolmentStatusType =:enrolmentStatusType ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
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
		
		Enrolment enrolment = new Enrolment();
		SpecOfferWave specOfferWave = new SpecOfferWave();
		EnrolmentStatusType enrolmentStatusType = new EnrolmentStatusType();
		
		EnrolmentStatus context = new EnrolmentStatus();
		context.setEnrolment(enrolment);
		context.setSpecOfferWave(specOfferWave);
		context.setEnrolmentStatusType(enrolmentStatusType);
		
		String expectedQuery = "SELECT e FROM EnrolmentStatus e WHERE ( e.enrolment = :enrolment OR e.specOfferWave =:specOfferWave OR e.enrolmentStatusType =:enrolmentStatusType ) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}	
}