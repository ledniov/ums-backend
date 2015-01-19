package org.lnu.is.extractor.reason;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.lnu.is.domain.common.RowStatus;
import org.lnu.is.domain.reason.Reason;


public class ReasonParametersExtractorTest {

	private ReasonParametersExtractor unit = new ReasonParametersExtractor();
	
	@Test
	public void testGetParameters() throws Exception {
		// Given
		String name = "Extract Me All";
		String abbrName = "EML";

		Reason entity = new Reason();
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
		Reason entity = new Reason();
		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("status", RowStatus.ACTIVE);
		// When
		Map<String, Object> actual = unit.getParameters(entity);

		// Then
		assertEquals(expected, actual);
	}
}
