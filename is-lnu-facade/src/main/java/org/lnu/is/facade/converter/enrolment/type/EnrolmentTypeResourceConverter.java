package org.lnu.is.facade.converter.enrolment.type;

import org.lnu.is.domain.enrolment.EnrolmentType;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.enrolment.type.EnrolmentTypeResource;

/**
 * Enrolment Type Resource Converter.
 * 
 * @author kushnir
 *
 */
@Converter("enrolmentTypeResourceConverter")
public class EnrolmentTypeResourceConverter extends AbstractConverter<EnrolmentTypeResource, EnrolmentType> {

	@Override
	public EnrolmentType convert(final EnrolmentTypeResource source, final EnrolmentType target) {
		target.setName(source.getName());

		return target;
	}

	@Override
	public EnrolmentType convert(final EnrolmentTypeResource source) {
		return convert(source, new EnrolmentType());
	}

}
