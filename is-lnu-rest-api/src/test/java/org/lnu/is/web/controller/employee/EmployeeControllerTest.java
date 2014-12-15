package org.lnu.is.web.controller.employee;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.is.facade.facade.Facade;
import org.lnu.is.facade.resource.employee.EmployeeResource;
import org.lnu.is.facade.resource.message.MessageResource;
import org.lnu.is.facade.resource.message.MessageType;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.web.controller.AbstractControllerTest;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest extends AbstractControllerTest {

	@Mock
	private Facade<EmployeeResource, Long> facade;
	
	@InjectMocks
	private EmployeeController unit;
	
    private MockMvc mockMvc;

    @Before
    public void setup() {
    	  this.mockMvc = MockMvcBuilders.standaloneSetup(unit).build();
    }
    
    @Test
	public void testCreateEmployee() throws Exception {
		// Given
    	String docNum = "docNum";
    	
    	EmployeeResource personResource = new EmployeeResource();
    	personResource.setBegDate(new Date());
		personResource.setDocNum(docNum);
		
		// When
    	String request = getJson(personResource, true);
		String response = getJson(personResource, false);
    	
		when(facade.createResource(any(EmployeeResource.class))).thenReturn(personResource);
		
    	// Then
		mockMvc.perform(post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
				.andExpect(status().isCreated())
				.andExpect(content().string(response));
		
		verify(facade).createResource(personResource);
	}
    
    @Test
	public void testUpdateEmployee() throws Exception {
		// Given
    	Long id = 1L;
    	String docNum = "docNum";
    	
    	EmployeeResource personResource = new EmployeeResource();
    	personResource.setId(id);
    	personResource.setBegDate(new Date());
		personResource.setDocNum(docNum);
		
		MessageResource responseResource = new MessageResource(MessageType.INFO, "Employee Updated");
		
		// When
    	String request = getJson(personResource, true);
		String response = getJson(responseResource, false);
    	
		
    	// Then
		mockMvc.perform(put("/employees/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
				.andExpect(status().isOk())
				.andExpect(content().string(response));
		
		verify(facade).updateResource(id, personResource);
	}
    
    @Test
	public void testGetSpecoffer() throws Exception {
		// Given
    	Long id = 1L;
    	String docNum = "docNum";
    	
    	EmployeeResource personResource = new EmployeeResource();
    	personResource.setId(id);
    	personResource.setBegDate(new Date());
		personResource.setDocNum(docNum);

		// When
		String response = getJson(personResource, false);
		
		when(facade.getResource(anyLong())).thenReturn(personResource);
		
		// Then
    	mockMvc.perform(get("/employees/{id}", id))
    		.andExpect(status().isOk())
    		.andExpect(content().string(response));
    	
    	verify(facade).getResource(id);
	}
    
    @Test
	public void testDeleteEmployee() throws Exception {
		// Given
    	Long id = 1L;
    	
		// When

		// Then
    	mockMvc.perform(delete("/employees/{id}", id))
    		.andExpect(status().is(204));
    	
    	verify(facade).removeResource(id);
	}
    
    @Test
	public void testGetEmployees() throws Exception {
		// Given
    	Long id = 1L;
    	String docNum = "docNum";
    	
    	EmployeeResource personResource = new EmployeeResource();
    	personResource.setId(id);
    	personResource.setBegDate(new Date());
		personResource.setDocNum(docNum);

    	long count = 100;
    	int limit = 25;
    	Integer offset = 10;
    	String uri = "/employees";
		List<EmployeeResource> entities = Arrays.asList(personResource);
    	PagedResultResource<EmployeeResource> expectedResource = new PagedResultResource<>();
		expectedResource.setCount(count);
		expectedResource.setLimit(limit);
		expectedResource.setOffset(offset);
		expectedResource.setUri(uri);
		expectedResource.setResources(entities);
		
		PagedRequest<EmployeeResource> pagedRequest = new PagedRequest<EmployeeResource>(new EmployeeResource(), offset, limit);
		
		// When
		when(facade.getResources(Matchers.<PagedRequest<EmployeeResource>>any())).thenReturn(expectedResource);
    	String response = getJson(expectedResource, false);

		// Then
    	mockMvc.perform(get("/employees")
    			.param("offset", String.valueOf(offset))
    			.param("limit", String.valueOf(limit)))
    		.andExpect(status().isOk())
    		.andExpect(content().string(response));
    	
		verify(facade).getResources(pagedRequest);
	}
}
