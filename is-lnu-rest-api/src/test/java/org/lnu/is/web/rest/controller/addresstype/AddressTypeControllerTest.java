package org.lnu.is.web.rest.controller.addresstype;

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
import org.lnu.is.facade.resource.addresstype.AddressTypeResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.web.rest.controller.AbstractControllerTest;
import org.lnu.is.web.rest.controller.BaseController;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddressTypeControllerTest extends AbstractControllerTest {

	@Mock
	private Facade<AddressTypeResource, Long> facade;

	@InjectMocks
	private AddressTypeController unit;

	@Test
	public void testGetAddressTypes() throws Exception {
		// Given
		String name = "AddressN";
		Integer offset = 0;
		Integer limit = 20;
		long count = 1;

		AddressTypeResource resource = new AddressTypeResource();
		resource.setName(name);

		List<AddressTypeResource> entities = Arrays.asList(resource);
		PagedResultResource<AddressTypeResource> expected = new PagedResultResource<>(
				"/addresstypes");
		expected.setResources(entities);
		expected.setCount(count);
		expected.setLimit(limit);
		expected.setOffset(offset);

		AddressTypeResource paramResource = new AddressTypeResource();
		paramResource.setName(name);

		PagedRequest<AddressTypeResource> request = new PagedRequest<AddressTypeResource>(
				paramResource, offset, limit);

		// When
		when(facade.getResources(Matchers.<PagedRequest<AddressTypeResource>> any())).thenReturn(expected);
		String response = getJson(expected, false);

		// Then
		mockMvc.perform(get("/addresstypes").param("name", name))
				.andExpect(status().isOk())
				.andExpect(content().string(response));

		verify(facade).getResources(request);

	}

	@Override
	protected BaseController getUnit() {
		return unit;
	}

}
