package org.lnu.is.converter.enrolment.subject;

import org.lnu.is.annotations.Converter;
import org.lnu.is.converter.AbstractConverter;
import org.lnu.is.domain.enrolment.subject.EnrolmentSubject;
import org.lnu.is.resource.enrolment.subject.EnrolmentSubjectResource;

/**
 * Enrolment Subject Resource Converter.
 * @author ivanursul
 *
 */
@Converter("enrolmentSubjectResourceConverter")
public class EnrolmentSubjectResourceConverter extends AbstractConverter<EnrolmentSubjectResource, EnrolmentSubject> {

	@Override
	public EnrolmentSubject convert(final EnrolmentSubjectResource source, final EnrolmentSubject target) {
		
		target.setAbbrName(source.getAbbrName());
		target.setName(source.getName());
		target.setIsTesting(source.getIsTesting());
		
		if (source.getParentId() != null) {
			EnrolmentSubject parent = new EnrolmentSubject();
			parent.setId(source.getParentId());
			
			target.setParent(parent);
		}
		
		return target;
	}

	@Override
	public EnrolmentSubject convert(final EnrolmentSubjectResource source) {
		return convert(source, new EnrolmentSubject());
	}

}
