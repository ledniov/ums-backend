package org.lnu.is.extractor.marriedtype;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.lnu.is.domain.common.RowStatus;
import org.lnu.is.domain.marriedtype.MarriedType;

public class MarriedTypeParametersExtractorTest {

	private MarriedTypeParametersExtractor unit = new MarriedTypeParametersExtractor();
	
	@Test
	public void testGetParameters() throws Exception {
		// Given
		String name = "Extract Me All";
		String abbrName = "EML";

		MarriedType entity = new MarriedType();
		entity.setName(name);
		entity.setAbbrName(abbrName);

		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("name", name);
		expected.put("abbrName", abbrName);
		expected.put("status", RowStatus.ACTIVE);
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testGetParametersWithDefaultEntity() throws Exception {
		// Given
		MarriedType entity = new MarriedType();
		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("status", RowStatus.ACTIVE);
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}
