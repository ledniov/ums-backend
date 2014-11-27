package org.lnu.is.facade.facade.enrolment.subject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.domain.enrolment.EnrolmentSubject;
import org.lnu.is.facade.converter.Converter;
import org.lnu.is.facade.resource.ApiResource;
import org.lnu.is.facade.resource.enrolment.subject.EnrolmentSubjectResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.service.enrolment.subject.EnrolmentSubjectService;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultEnrolmentSubjectFacadeTest {

	@InjectMocks
	private DefaultEnrolmentSubjectFacade unit;

	@Mock
	private Converter<PagedRequest<EnrolmentSubjectResource>, PagedSearch<EnrolmentSubject>> pagedRequestConverter;

	@Mock
	private Converter<PagedResult<?>, PagedResultResource<? extends ApiResource>> pagedResultConverter;
	
	@Mock
	private EnrolmentSubjectService service;

	@Mock
	private Converter<EnrolmentSubject, EnrolmentSubjectResource> entityConverter;
	
	@Mock
	private Converter<EnrolmentSubjectResource, EnrolmentSubject> resourceConverter;
	
	@Test
	public void testGetSpecialties() throws Exception {
		// Given
		EnrolmentSubjectResource resource = new EnrolmentSubjectResource();
		PagedRequest<EnrolmentSubjectResource> pagedRequest = new PagedRequest<EnrolmentSubjectResource>(resource, 10, 10);
		List<EnrolmentSubjectResource> funnyResources = Collections.singletonList(new EnrolmentSubjectResource());
		PagedResultResource<EnrolmentSubjectResource> expectedFunnies = new PagedResultResource<>("/enrolments/subjects");
		expectedFunnies.setResources(funnyResources);

		int offset = 8;
		int limit = 3;
		int count = 100;
		
		PagedSearch<EnrolmentSubject> pagedSearch = new PagedSearch<EnrolmentSubject>(offset, limit, Collections.<String, Object> emptyMap(), EnrolmentSubject.class);
		List<EnrolmentSubject> entities = Arrays.asList(new EnrolmentSubject());
		PagedResult<EnrolmentSubject> pagedResult = new PagedResult<EnrolmentSubject>(offset, limit, count, entities);

		// When
		when(pagedRequestConverter.convert(Matchers.<PagedRequest<EnrolmentSubjectResource>>any())).thenReturn(pagedSearch);
		when(service.getEnrolmentSubjects(Matchers.<PagedSearch<EnrolmentSubject>> any())).thenReturn(pagedResult);
		when(entityConverter.convertAll(anyListOf(EnrolmentSubject.class))).thenReturn(funnyResources);

		PagedResultResource<EnrolmentSubjectResource> actualFunnies = unit.getEntities(pagedRequest);

		// Then
		verify(pagedRequestConverter).convert(pagedRequest);
		verify(service).getEnrolmentSubjects(pagedSearch);
		verify(entityConverter).convertAll(entities);
		verify(pagedResultConverter).convert(pagedResult, expectedFunnies);

		assertEquals(expectedFunnies, actualFunnies);
	}
}
