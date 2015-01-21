package org.lnu.is.dao.builder.specoffer;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.eduformtype.EduFormType;
import org.lnu.is.domain.specialty.Specialty;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.lnu.is.domain.specoffer.SpecOfferType;
import org.lnu.is.domain.timeperiod.TimePeriod;

public class SpecOfferQueryBuilderTest {

	private SpecOfferQueryBuilder unit = new SpecOfferQueryBuilder();
	
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
		Specialty specialty = new Specialty();
		TimePeriod timePeriod = new TimePeriod();
		SpecOffer parent = new SpecOffer();
		SpecOfferType specOfferType = new SpecOfferType();
		EduFormType eduFormType = new EduFormType();
		Department department = new Department();
		String docSeries = "docSeries";
		String docNum = "docNum";
		Integer licCount = 2;
		Integer stateCount = 45;

		SpecOffer context = new SpecOffer();
		context.setBegDate(new Date());
		context.setEndDate(new Date());
		context.setDepartment(department);
		context.setDocNum(docNum);
		context.setDocSeries(docSeries);
		context.setEduFormType(eduFormType);
		context.setLicCount(licCount);
		context.setParent(parent);
		context.setSpecialty(specialty);
		context.setSpecOfferType(specOfferType);
		context.setStateCount(stateCount);
		context.setTimePeriod(timePeriod);
		
		String expectedQuery = "SELECT e FROM SpecOffer e WHERE ( e.parent = :parent OR e.specialty = :specialty OR e.department = :department OR e.timePeriod = :timePeriod OR e.eduFormType = :eduFormType OR e.specOfferType :specOfferType OR e.docSeries LIKE CONCAT('%',:docSeries,'%') OR e.docNum LIKE CONCAT('%',:docNum,'%') OR e.licCount = :licCount OR e.stateCount = :stateCount OR e.begDate <= :begDate OR e.endDate >= :endDate) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithOneParameter() throws Exception {
		// Given
		SpecOffer parent = new SpecOffer();
		
		SpecOffer context = new SpecOffer();
		context.setParent(parent);
		
		String expectedQuery = "SELECT e FROM SpecOffer e WHERE ( e.parent = :parent ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithExmptyParameters() throws Exception {
		// Given
		SpecOffer context = new SpecOffer();
		String expectedQuery = "SELECT e FROM SpecOffer e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
