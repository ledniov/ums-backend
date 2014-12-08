package org.lnu.is.extractor.enrolment;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.enrolment.Enrolment;
import org.lnu.is.domain.enrolment.EnrolmentType;
import org.lnu.is.domain.person.Person;
import org.lnu.is.domain.person.PersonPaper;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.lnu.is.extractor.AbstractParametersExtractor;
import org.springframework.stereotype.Component;

/**
 * Enrolment parameters extractor.
 * 
 * @author kushnir
 *
 */
@Component("enrolmentParametersExtractor")
public class EnrolmentParametersExtractor extends AbstractParametersExtractor<Enrolment> {

	@Resource(name = "personDao")
	private Dao<Person, Long> personDao;

	@Resource(name = "specOfferDao")
	private Dao<SpecOffer, Long> specOfferDao;

	@Resource(name = "departmentDao")
	private Dao<Department, Long> departmentDao;

	@Resource(name = "personPaperDao")
	private Dao<PersonPaper, Long> personPaperDao;

	@Resource(name = "enrolmentTypeDao")
	private Dao<EnrolmentType, Long> enrolmentTypeDao;

	@Resource(name = "enrolmentDao")
	private Dao<Enrolment, Long> enrolmentDao;

	@Override
	public Map<String, Object> getParameters(final Enrolment entity) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		addParameter(entity.getPerson(), personDao, "person", parameters);
		addParameter(entity.getSpecOffer(), specOfferDao, "specOffer", parameters);
		addParameter(entity.getDepartment(), departmentDao, "department", parameters);
		addParameter(entity.getPersonPaper(), personPaperDao, "personPaper", parameters);
		addParameter(entity.getEnrolmentType(), enrolmentDao, "enrolmentDao", parameters);
		addParameter(entity.getParent(), enrolmentDao, "parent", parameters);

		addParameter(entity.getMark(), "mark", parameters);
		addParameter(entity.getDocSeries(), "docSeries", parameters);
		addParameter(entity.getDocNum(), "docNum", parameters);
		addParameter(entity.getDocText(), "docText", parameters);
		addParameter(entity.getIsState(), "isState", parameters);
		addParameter(entity.getIsHostel(), "isHostel", parameters);
		addParameter(entity.getIsPrivilege(), "isPrivilege", parameters);
		addParameter(entity.getIsContract(), "isContract", parameters);
		addParameter(entity.getEvDate(), "evDate", parameters);
		addParameter(entity.getBegDate(), "begDate", parameters);
		addParameter(entity.getEndDate(), "endDate", parameters);

		return parameters;

	}
}