package org.lnu.is.web.rest.controller.department.type;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.facade.facade.Facade;
import org.lnu.is.resource.department.type.DepartmentTypeResource;
import org.lnu.is.resource.search.PagedRequest;
import org.lnu.is.resource.search.PagedResultResource;
import org.lnu.is.web.rest.controller.AbstractControllerTest;
import org.lnu.is.web.rest.controller.BaseController;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentTypeControllerTest extends AbstractControllerTest {

	@Mock
	private Facade<DepartmentTypeResource, Long> facade;

	@InjectMocks
	private DepartmentTypeController unit;
	
	@Override
	protected BaseController getUnit() {
		return unit;
	}

	@Test
	public void testGetEduFormTypes() throws Exception {
		// Given
		String name = "Gender Type One";
		DepartmentTypeResource resource = new DepartmentTypeResource();
		resource.setName(name);

		List<DepartmentTypeResource> entities = Arrays.asList(resource);

		Integer offset = 0;
		long count = 1;
		Integer limit = 20;

		PagedResultResource<DepartmentTypeResource> expected = new PagedResultResource<>("/departments/types");
		expected.setResources(entities);
		expected.setCount(count);
		expected.setLimit(limit);
		expected.setOffset(offset);

		DepartmentTypeResource paramResource = new DepartmentTypeResource();
		paramResource.setName(name);
		PagedRequest<DepartmentTypeResource> request = new PagedRequest<DepartmentTypeResource>(paramResource, offset, limit);

		// When
		when(facade.getResources(Matchers.<PagedRequest<DepartmentTypeResource>> any())).thenReturn(expected);
		String response = getJson(expected, false);

		// Then
		mockMvc.perform(get("/departments/types")
				.param("name", name))
				.andExpect(status().isOk())
				.andExpect(content().string(response));

		verify(facade).getResources(request);
	}
}
