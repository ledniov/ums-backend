package org.lnu.is.dao.builder.marriedtype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.marriedtype.MarriedType;

public class MarriedTypeQueryBuilderTest {
	
	private MarriedTypeQueryBuilder unit = new MarriedTypeQueryBuilder();

	@Test
	public void testBuild() throws Exception {
		// Given
		String abbrName = "Diablo";
		
		MarriedType context = new MarriedType();
		context.setAbbrName(abbrName);

		String expectedQuery = "SELECT m FROM MarriedType m WHERE m.abbrName LIKE CONCAT('%',:abbrName,'%') ";

		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}

}