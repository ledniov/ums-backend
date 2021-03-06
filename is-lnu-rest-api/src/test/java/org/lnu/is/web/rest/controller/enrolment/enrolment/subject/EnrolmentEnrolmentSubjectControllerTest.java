package org.lnu.is.web.rest.controller.enrolment.enrolment.subject;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.AccessDeniedException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.facade.facade.Facade;
import org.lnu.is.pagination.OrderBy;
import org.lnu.is.resource.enrolment.enrolment.subject.EnrolmentEnrolmentSubjectResource;
import org.lnu.is.resource.message.MessageResource;
import org.lnu.is.resource.message.MessageType;
import org.lnu.is.resource.search.PagedRequest;
import org.lnu.is.resource.search.PagedResultResource;
import org.lnu.is.web.rest.controller.AbstractControllerTest;
import org.lnu.is.web.rest.controller.BaseController;
import org.lnu.is.web.rest.controller.enrolment.enrolment.subject.EnrolmentEnrolmentSubjectController;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;

@RunWith(MockitoJUnitRunner.class)
public class EnrolmentEnrolmentSubjectControllerTest extends AbstractControllerTest {
    @Mock
    private Facade<EnrolmentEnrolmentSubjectResource, EnrolmentEnrolmentSubjectResource, Long> facade;

    @InjectMocks
    private EnrolmentEnrolmentSubjectController unit;

    @Override
    protected BaseController getUnit() {
	return unit;
    }

    @Test
    public void testCreateEnrolmentEnrolmentSubject() throws Exception {
	// Given
	Long id = 1L;
	Long enrolmentId = 2L;
	EnrolmentEnrolmentSubjectResource enrolmentEnrolmentSubjectResource = new EnrolmentEnrolmentSubjectResource();
	enrolmentEnrolmentSubjectResource.setId(id);
	enrolmentEnrolmentSubjectResource.setEnrolmentId(enrolmentId);
	
	// When
	String request = getJson(enrolmentEnrolmentSubjectResource, true);
	String response = getJson(enrolmentEnrolmentSubjectResource, false);

	when(facade.createResource(any(EnrolmentEnrolmentSubjectResource.class)))
		.thenReturn(enrolmentEnrolmentSubjectResource);

	// Then
	mockMvc.perform(
		post("/enrolments/{enrolmentId}/enrolmentsubjects", enrolmentId)
			.contentType(MediaType.APPLICATION_JSON).content(
				request)).andExpect(status().isCreated())
		.andExpect(content().string(response));

	verify(facade).createResource(enrolmentEnrolmentSubjectResource);
    }

    @Test
    public void testUpdateEnrolmentEnrolmentSubject() throws Exception {
	// Given
	Long id = 5L;
	Long enrolmentId = 2L;
	Long enrolmentSubjectId = 6L;
	Long personEnrolmentSubjectId = 3L;
	Double mark = 4D;
	EnrolmentEnrolmentSubjectResource enrolmentEnrolmentSubjectResource = new EnrolmentEnrolmentSubjectResource();
	enrolmentEnrolmentSubjectResource.setId(id);
	enrolmentEnrolmentSubjectResource.setEnrolmentSubjectId(enrolmentSubjectId);
	enrolmentEnrolmentSubjectResource.setEnrolmentId(enrolmentId);
	enrolmentEnrolmentSubjectResource.setPersonEnrolmentSubjectId(personEnrolmentSubjectId);
	enrolmentEnrolmentSubjectResource.setMark(mark);

	MessageResource responseResource = new MessageResource(
		MessageType.INFO, "Enrolment Enrolment Subject Updated");

	// When
	String request = getJson(enrolmentEnrolmentSubjectResource, true);
	String response = getJson(responseResource, false);

	// Then
	mockMvc.perform(
		put(
			"/enrolments/{enrolmentId}/enrolmentsubjects/{enrolmentEnrolmentSubjectId}",
			enrolmentId, id).contentType(MediaType.APPLICATION_JSON)
			.content(request)).andExpect(status().isOk())
		.andExpect(content().string(response));

	verify(facade).updateResource(id, enrolmentEnrolmentSubjectResource);
    }

    @Test
    public void testDeleteEnrolmentEnrolmentSubject() throws Exception {
	// Given
	Long enrolmentId = 2L;
	Long enrolmentSubjectId = 5L;

	// When

	// Then
	mockMvc.perform(
		delete("/enrolments/{enrolmentId}/enrolmentsubjects/{enrolmentSubjectId}",
			enrolmentId, enrolmentSubjectId)).andExpect(
		status().is(204));

	verify(facade).removeResource(enrolmentSubjectId);
    }

    @Test
    public void testGetPersonEnrolmentSubjects() throws Exception {
	// Given
	Long enrolmentId = 2L;
	Long id = 5L;

	EnrolmentEnrolmentSubjectResource enrolmentEnrolmentSubjectResource = new EnrolmentEnrolmentSubjectResource();
	enrolmentEnrolmentSubjectResource.setId(id);
	enrolmentEnrolmentSubjectResource.setEnrolmentId(enrolmentId);
	

	// When
	String response = getJson(enrolmentEnrolmentSubjectResource, false);

	when(facade.getResource(anyLong())).thenReturn(
		enrolmentEnrolmentSubjectResource);

	// Then
	mockMvc.perform(
		get("/enrolments/{enrolmentId}/enrolmentsubjects/{enrolmentEnrolmentSubjectId}",
			enrolmentId, id)).andExpect(status().isOk())
		.andExpect(content().string(response));

	verify(facade).getResource(id);
    }

    @Test
    public void testGetEnrolmentSubjects() throws Exception {
	// Given
	Long id = 5L;
	Long enrolmentId = 2L;

	EnrolmentEnrolmentSubjectResource enrolmentSubjectResource = new EnrolmentEnrolmentSubjectResource();
	enrolmentSubjectResource.setId(id);
	enrolmentSubjectResource.setEnrolmentId(enrolmentId);

	long count = 100;
	int limit = 25;
	Integer offset = 10;
	String uri = MessageFormat.format("/enrolments/{0}/enrolmentsubjects",
		enrolmentId);
	List<EnrolmentEnrolmentSubjectResource> entities = Arrays
		.asList(enrolmentSubjectResource);
	PagedResultResource<EnrolmentEnrolmentSubjectResource> expectedResource = new PagedResultResource<>();
	expectedResource.setCount(count);
	expectedResource.setLimit(limit);
	expectedResource.setOffset(offset);
	expectedResource.setUri(uri);
	expectedResource.setResources(entities);

	EnrolmentEnrolmentSubjectResource resource = new EnrolmentEnrolmentSubjectResource();
	resource.setEnrolmentId(enrolmentId);
	PagedRequest<EnrolmentEnrolmentSubjectResource> pagedRequest = new PagedRequest<EnrolmentEnrolmentSubjectResource>(
		resource, offset, limit, Collections.<OrderBy> emptyList());

	// When
	when(
		facade.getResources(Matchers
			.<PagedRequest<EnrolmentEnrolmentSubjectResource>> any()))
		.thenReturn(expectedResource);
	String response = getJson(expectedResource, false);

	// Then
	mockMvc.perform(
		get("/enrolments/{enrolmentId}/enrolmentsubjects", enrolmentId).param(
			"offset", String.valueOf(offset)).param("limit",
			String.valueOf(limit))).andExpect(status().isOk())
		.andExpect(content().string(response));

	verify(facade).getResources(pagedRequest);
    }

    @Test(expected = AccessDeniedException.class)
    public void testGetResourceWithAccessDeniedException() throws Exception {
	// Given
	Long id = 5L;
	Long enrolmentId = 2L;

	// When
	doThrow(AccessDeniedException.class).when(facade)
		.getResource(anyLong());

	// Then
	mockMvc.perform(get("/enrolments/{enrolmentId}/enrolmentsubjects/{id}",
		enrolmentId, id));

	verify(facade).getResource(id);
    }
}
