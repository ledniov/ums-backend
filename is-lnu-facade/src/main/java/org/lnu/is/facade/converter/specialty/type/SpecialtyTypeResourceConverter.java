package org.lnu.is.facade.converter.specialty.type;

import org.lnu.is.domain.specialty.SpecialtyType;
import org.lnu.is.facade.annotations.Converter;
import org.lnu.is.facade.converter.AbstractConverter;
import org.lnu.is.facade.resource.specialty.type.SpecialtyTypeResource;

/**
 * Specialty Type resource converter.
 * @author ivanursul
 *
 */
@Converter("specialtyTypeResourceConverter")
public class SpecialtyTypeResourceConverter extends AbstractConverter<SpecialtyTypeResource, SpecialtyType> {

	@Override
	public SpecialtyType convert(final SpecialtyTypeResource source, final SpecialtyType target) {
		
		target.setAbbrName(source.getAbbrName());
		target.setName(source.getName());
		
		return target;
	}

	@Override
	public SpecialtyType convert(final SpecialtyTypeResource source) {
		return convert(source, new SpecialtyType());
	}

}
