package org.lnu.is.dao.builder.timesheet.type;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.timesheettype.TimeSheetType;

public class TimesheetTypeQueryBuilderTest {

	private TimesheetTypeQueryBuilder unit = new TimesheetTypeQueryBuilder();
	
	@Test
	public void testBuild() throws Exception {
		// Given
		TimeSheetType context = new TimeSheetType();
		
		String expectedQuery = "SELECT e FROM TimeSheetType e WHERE e.status=:status ";
		
		// When
		String actualQuery = unit.build(context);
		
		// Then
		assertEquals(expectedQuery, actualQuery);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String abbrName = "TestString";
		String name = "fsdds";
		
		TimeSheetType context = new TimeSheetType();
		context.setAbbrName(abbrName);
		context.setName(name);

		String expectedQuery = "SELECT e FROM TimeSheetType e WHERE ( e.name LIKE CONCAT('%',:name,'%') OR e.abbrName LIKE CONCAT('%',:abbrName,'%') ) AND e.status=:status ";
		// When
		String actualQuery = unit.build(context);

		// Then
		assertEquals(expectedQuery, actualQuery);
	}
}
