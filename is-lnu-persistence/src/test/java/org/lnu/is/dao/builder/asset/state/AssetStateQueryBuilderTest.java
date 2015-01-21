package org.lnu.is.dao.builder.asset.state;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lnu.is.domain.asset.AssetState;

public class AssetStateQueryBuilderTest {

	private AssetStateQueryBuilder unit = new AssetStateQueryBuilder();
	
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
		AssetState context = new AssetState();
		
		String expected = "SELECT e FROM AssetState e WHERE e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		// When
		String actual = unit.build(context);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testBuildWithParameters() throws Exception {
		// Given
		String name = "name";
		AssetState context = new AssetState();
		context.setName(name);
		
		String expected = "SELECT e FROM AssetState e WHERE ( a.name LIKE CONCAT('%',:name,'%') ) AND e.status=:status AND e.crtUserGroup IN (:userGroups) ";
		// When
		String actual = unit.build(context);
		
		// Then
		assertEquals(expected, actual);
	}
}
