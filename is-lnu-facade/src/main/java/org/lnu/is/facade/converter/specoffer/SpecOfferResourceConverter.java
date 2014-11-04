package org.lnu.is.facade.converter.specoffer;

import java.util.Date;

import org.lnu.is.domain.department.Department;
import org.lnu.is.domain.eduformtype.EduFormType;
import org.lnu.is.domain.specialty.Specialty;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.lnu.is.domain.specoffertype.SpecOfferType;
import org.lnu.is.domain.timeperiod.TimePeriod;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.specoffer.SpecOfferResource;

/**
 * Converter, that convert from Resource to Entity.
 * @author ivanursul
 *
 */
@Converter("specOfferResourceConverter")
public class SpecOfferResourceConverter extends AbstractConverter<SpecOfferResource, SpecOffer> {

	@Override
	public SpecOffer convert(final SpecOfferResource source, final SpecOffer target) {
		
		Department department = new Department();
		department.setId(source.getDepartmentId());
		
		EduFormType eduFormType = new EduFormType();
		eduFormType.setId(source.getEduFormTypeId());
		
		Specialty specialty = new Specialty();
		specialty.setId(source.getSpecialtyId());

		SpecOfferType specOfferType = new SpecOfferType();
		specOfferType.setId(source.getSpecofferTypeId());

		TimePeriod timePeriod = new TimePeriod();
		timePeriod.setId(source.getTimePeriodId());

		target.setBegDate(source.getBegDate());
		target.setDepartment(department);
		target.setDocNum(source.getDocNum());
		target.setDocSeries(source.getDocSeries());
		target.setEduFormType(eduFormType);
		target.setEndDate(source.getEndDate());
		target.setId(source.getId());
		target.setLicCount(source.getLicCount());
		target.setNote(source.getNote());
		target.setSpecialty(specialty);
		target.setSpecOfferType(specOfferType);
		target.setStateCount(source.getStateCount());
		target.setTimePeriod(timePeriod);
		target.setUpdateDate(new Date());
		
		return target;
	}

	@Override
	public SpecOffer convert(final SpecOfferResource source) {
		return convert(source, new SpecOffer());
	}

}