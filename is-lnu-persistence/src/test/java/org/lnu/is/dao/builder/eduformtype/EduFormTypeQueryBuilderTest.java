package org.lnu.is.dao.builder.eduformtype;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.dao.builder.education.form.type.EduFormTypeQueryBuilder;
import org.lnu.is.domain.education.form.type.EducationFormType;
import org.lnu.is.pagination.MultiplePagedSearch;

public class EduFormTypeQueryBuilderTest {

	private EduFormTypeQueryBuilder unit = new EduFormTypeQueryBuilder();
	
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
		EducationFormType context = new EducationFormType();
		
		String expectedQuery = "SELECT e FROM EduFormType e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledSecurityConstraint() throws Exception {
		// Given
		unit.setSecurity(false);
		
		EducationFormType context = new EducationFormType();
		
		String expectedQuery = "SELECT e FROM EduFormType e WHERE e.status=:status ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledStatusCOnstraint() throws Exception {
		// Given
		unit.setActive(false);
		
		EducationFormType context = new EducationFormType();
		
		String expectedQuery = "SELECT e FROM EduFormType e WHERE e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithDisabledDefaultConstraints() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		EducationFormType context = new EducationFormType();
		
		String expectedQuery = "SELECT e FROM EduFormType e ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String name = "name";
		EducationFormType context = new EducationFormType();
		context.setName(name);

		String expectedQuery = "SELECT e FROM EduFormType e WHERE ( e.name LIKE CONCAT('%',:name,'%') ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
	
	@Test
	public void testBuildWithParametersAndDisabledDefaultConstraints() throws Exception {
		// Given
		unit.setActive(false);
		unit.setSecurity(false);
		
		String name = "name";
		EducationFormType context = new EducationFormType();
		context.setName(name);
		
		String expectedQuery = "SELECT e FROM EduFormType e WHERE ( e.name LIKE CONCAT('%',:name,'%') ) ";
		MultiplePagedSearch<EducationFormType> pagedSearch = new MultiplePagedSearch<>();
		pagedSearch.setEntity(context);
		
		// When
		String actualQuery = unit.build(pagedSearch);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
