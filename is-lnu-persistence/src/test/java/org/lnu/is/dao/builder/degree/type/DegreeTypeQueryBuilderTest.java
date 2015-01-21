package org.lnu.is.dao.builder.degree.type;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.degree.DegreeType;

public class DegreeTypeQueryBuilderTest {

	private DegreeTypeQueryBuilder unit = new DegreeTypeQueryBuilder();
	
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
		DegreeType context = new DegreeType();

		String expectedQuery = "SELECT e FROM DegreeType e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";

		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String abbrName = "AN";
		String name = "namdsfsd";
		
		DegreeType context = new DegreeType();
		context.setAbbrName(abbrName);
		context.setName(name);
		
		String expectedQuery = "SELECT e FROM DegreeType e WHERE ( e.name LIKE CONCAT('%',:name,'%') OR e.abbrname LIKE CONCAT('%',:abbrName,'%') ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
