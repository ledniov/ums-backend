package org.lnu.is.converter.eduformtype;

import org.lnu.is.annotations.Converter;
import org.lnu.is.converter.AbstractConverter;
import org.lnu.is.domain.eduformtype.EduFormType;
import org.lnu.is.resource.eduformtype.EduFormTypeResource;

/**
 * Edu Form Type Resorce Converter.
 * @author ivanursul
 *
 */
@Converter("eduFormTypeResourceConverter")
public class EduFormTypeResourceConverter extends AbstractConverter<EduFormTypeResource, EduFormType> {

	@Override
	public EduFormType convert(final EduFormTypeResource source, final EduFormType target) {
		
		target.setName(source.getName());
		
		return target;
	}

	@Override
	public EduFormType convert(final EduFormTypeResource source) {
		return convert(source, new EduFormType());
	}

}
