package org.lnu.is.facade.facade.gendertype;

import java.util.List;

import javax.annotation.Resource;

import org.lnu.is.domain.gendertype.GenderType;
import org.lnu.is.facade.annotations.Facade;
import org.lnu.is.facade.converter.Converter;
import org.lnu.is.facade.facade.BaseFacade;
import org.lnu.is.facade.resource.gendertype.GenderTypeResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.pagination.PagedResult;
import org.lnu.is.pagination.PagedSearch;
import org.lnu.is.service.gendertype.GenderTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Gender Type Facade.
 * 
 * @author kushnir
 *
 */
@Transactional
@Facade("genderTypeFacade")
public class DefaultGenderTypeFacade extends BaseFacade<GenderTypeResource, GenderType> implements GenderTypeFacade {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultGenderTypeFacade.class);
	
	@Resource(name = "genderTypeConverter")
	private Converter<GenderType, GenderTypeResource> genderTypeConverter;

	@Resource(name = "genderTypeResourceConverter")
	private Converter<GenderTypeResource, GenderType> genderTypeResourceConverter;

	@Resource(name = "genderTypeService")
	private GenderTypeService genderTypeService;

	@Override
	public PagedResultResource<GenderTypeResource> getGenderTypes(final PagedRequest<GenderTypeResource> request) {
		LOG.info("Getting paged result for gender types: {}", request);
		
		PagedSearch<GenderType> pagedSearch = pagedRequestConverter.convert(request);
		pagedSearch.setEntity(genderTypeResourceConverter.convert(request.getResource()));

		PagedResult<GenderType> pagedResult = genderTypeService.getGenderTypes(pagedSearch);
		List<GenderTypeResource> resources = genderTypeConverter.convertAll(pagedResult.getEntities());

		PagedResultResource<GenderTypeResource> pagedResultResource = new PagedResultResource<>("/gendertypes");
		pagedResultResource.setResources(resources);
		pagedResultConverter.convert(pagedResult, pagedResultResource);

		return pagedResultResource;
	}

}
