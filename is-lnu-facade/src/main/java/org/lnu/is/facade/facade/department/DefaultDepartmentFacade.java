package org.lnu.is.facade.facade.department;

import java.util.List;

import javax.annotation.Resource;

import org.lnu.is.domain.department.Department;
import org.lnu.is.facade.annotations.Facade;
import org.lnu.is.facade.converter.Converter;
import org.lnu.is.facade.facade.BaseFacade;
import org.lnu.is.facade.resource.department.DepartmentResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.service.department.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implemenntation of facade for Deparment.
 * @author ivanursul
 *
 */
@Transactional
@Facade("departmentFacade")
public class DefaultDepartmentFacade extends BaseFacade<DepartmentResource, Department> implements DepartmentFacade {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultDepartmentFacade.class);
	
	@Resource(name = "departmentService")
	private DepartmentService departmentService;

	@Resource(name = "departmentResourceConverter")
	private Converter<DepartmentResource, Department> departmentResourceConverter;

	@Resource(name = "departmentConverter")
	private Converter<Department, DepartmentResource> departmentConverter;
	
	@Override
	public DepartmentResource createDepartment(final DepartmentResource resource) {
		LOG.info("Creating department: {}", resource);
		
		Department department = new Department();
		
		departmentResourceConverter.convert(resource, department);
		insertConverter.convert(resource, department);
		
		departmentService.createDepartment(department);
		
		return departmentConverter.convert(department);
	}

	@Override
	public void updateDepartment(final Long id, final DepartmentResource resource) {
		LOG.info("Updating department:{}, {}", id, resource);
		
		Department department = departmentService.getDepartment(id);
		
		departmentResourceConverter.convert(resource, department);
		updateConverter.convert(resource, department);
		
		departmentService.updateDepartment(department);
	}

	@Override
	public DepartmentResource getDepartment(final Long id) {
		LOG.info("Getting department: {}", id);
		
		Department department = departmentService.getDepartment(id);
		return departmentConverter.convert(department);
	}

	@Override
	public void removeDepartment(final Long id) {
		LOG.info("Removing department: {}", id);
		
		Department department = departmentService.getDepartment(id);
		departmentService.removeDepartment(department);
	}

	@Override
	public PagedResultResource<DepartmentResource> getDepartments(final PagedRequest<DepartmentResource> request) {
		LOG.info("Get departments by paged request: {}", request);

		PagedSearch<Department> pagedSearch = pagedRequestConverter.convert(request);
		pagedSearch.setEntity(departmentResourceConverter.convert(request.getResource()));

		PagedResult<Department> pagedResult = departmentService.getDepartments(pagedSearch);

		List<DepartmentResource> resources = departmentConverter.convertAll(pagedResult.getEntities());

		PagedResultResource<DepartmentResource> pagedResultResource = new PagedResultResource<>("/departments");
		pagedResultResource.setResources(resources);
		pagedResultConverter.convert(pagedResult, pagedResultResource);

		return pagedResultResource;
	}
	
}
