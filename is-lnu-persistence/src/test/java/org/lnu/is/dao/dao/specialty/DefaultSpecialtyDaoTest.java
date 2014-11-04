package org.lnu.is.dao.dao.specialty;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.dao.dao.specialty.DefaultSpecialtyDao;
import org.lnu.is.dao.persistence.PersistenceManager;
import org.lnu.is.domain.specialty.Specialty;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.queries.Queries;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSpecialtyDaoTest {

	@Mock
	private PersistenceManager<Specialty, Long> persistenceManager;
	
	@InjectMocks
	private DefaultSpecialtyDao unit;
	
	@Test
	public void testGetSpecialties() throws Exception {
		// Given
		int offset = 8;
		int limit = 3;
		int count = 100;
		
		PagedSearch<Specialty> pagedSearch = new PagedSearch<Specialty>(offset, limit, Queries.FIND_SPECIALTIES, Collections.<String, Object> emptyMap(), Specialty.class);

		Specialty entity1 = new Specialty();
		List<Specialty> entities = Arrays.asList(entity1);
		PagedResult<Specialty> expected = new PagedResult<Specialty>(offset, limit, count, entities);
		
		// When
		when(persistenceManager.search(Matchers.<PagedSearch<Specialty>>any())).thenReturn(expected);
		PagedResult<Specialty> actual = unit.getSpecialties(pagedSearch);

		// Then
		verify(persistenceManager).search(pagedSearch);
		assertEquals(expected, actual);
	}
}