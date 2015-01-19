package org.lnu.is.dao.builder.honor.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.honorstype.HonorType;

public class HonorTypeQueryBuilderTest {

	private HonorTypeQueryBuilder unit = new HonorTypeQueryBuilder();

	@Test
	public void testBuild() throws Exception {
		// Given
		HonorType context = new HonorType();

		String expectedQuery = "SELECT e FROM HonorType e WHERE e.status=:status ";

		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String name = "fsdfds";
		String abbrName = "abbrname";
		HonorType context = new HonorType();
		context.setAbbrName(abbrName);
		context.setName(name);
		
		String expectedQuery = "SELECT e FROM HonorType e WHERE ( e.name LIKE CONCAT('%',:name,'%') OR e.abbrName LIKE CONCAT('%',:abbrName,'%') ) AND e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
