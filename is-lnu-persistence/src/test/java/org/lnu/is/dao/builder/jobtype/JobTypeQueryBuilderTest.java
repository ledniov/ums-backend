package org.lnu.is.dao.builder.jobtype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.jobtype.JobType;

public class JobTypeQueryBuilderTest {

	private JobTypeQueryBuilder unit = new JobTypeQueryBuilder();

	@Test
	public void testBuild() throws Exception {
		// Given
		JobType context = new JobType();

		String expectedQuery = "SELECT e FROM JobType e WHERE e.status=:status ";

		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String abbrName = "LieToMe";
		String name = "fdsfds";
		
		JobType context = new JobType();
		context.setAbbrName(abbrName);
		context.setName(name);
		
		String expectedQuery = "SELECT e FROM JobType e WHERE ( e.name LIKE CONCAT('%',:name,'%') OR e.abbrName LIKE CONCAT('%',:abbrName,'%') ) AND e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}