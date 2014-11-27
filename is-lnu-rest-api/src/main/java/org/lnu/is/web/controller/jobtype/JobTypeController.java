package org.lnu.is.web.controller.jobtype;

import javax.annotation.Resource;

import org.lnu.is.facade.facade.jobtype.JobTypeFacade;
import org.lnu.is.facade.resource.jobtype.JobTypeResource;
import org.lnu.is.facade.resource.search.PagedRequest;
import org.lnu.is.facade.resource.search.PagedResultResource;
import org.lnu.is.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * @author kushnir
 *
 */
@RestController
@RequestMapping("/jobtypes")
@ApiModel(value = "Job Types", description = "Job Types")
public class JobTypeController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(JobTypeController.class);

	@Resource(name = "jobTypeFacade")
	private JobTypeFacade jobTypeFacade;

	/**
	 * Method for getting Job Types.
	 * @param offset
	 * @param limit
	 * @param resource
	 * @return paged result
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get All Job Types")
	public PagedResultResource<JobTypeResource> getJobTypes(
			@RequestParam(value = "offset", defaultValue = "0") final Integer offset,
			@RequestParam(value = "limit", defaultValue = "38") final Integer limit,
			final JobTypeResource resource) {
		LOG.info("Getting PagedResultResource for Job Type with  offset: {}, limit: {}", offset, limit);
		PagedRequest<JobTypeResource> request = new PagedRequest<JobTypeResource>(resource, offset, limit);
		return jobTypeFacade.getEntities(request);
	}

}
