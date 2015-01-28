package org.lnu.is.converter.specoffer.benefit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.lnu.is.domain.benefit.Benefit;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.lnu.is.domain.specoffer.SpecOfferBenefit;
import org.lnu.is.resource.specoffer.benefit.SpecOfferBenefitResource;

public class SpecOfferBenefitResourceConverterTest {

	private SpecOfferBenefitResourceConverter unit = new SpecOfferBenefitResourceConverter();
	
	@Test
	public void testConvert() throws Exception {
		// Given
		Long specOfferId = 2L;
		Long benefitId = 1L;
		SpecOfferBenefitResource source = new SpecOfferBenefitResource();
		source.setBenefitId(benefitId);
		source.setSpecOfferId(specOfferId);

		Benefit benefit = new Benefit();
		benefit.setId(benefitId);
		
		SpecOffer specOffer = new SpecOffer();
		specOffer.setId(specOfferId);
		
		SpecOfferBenefit expected = new SpecOfferBenefit();
		expected.setBenefit(benefit);
		expected.setSpecOffer(specOffer);
		
		// When
		SpecOfferBenefit actual = unit.convert(source);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testConvertWithNoRelations() throws Exception {
		// Given
		SpecOfferBenefitResource source = new SpecOfferBenefitResource();
		
		
		SpecOfferBenefit expected = new SpecOfferBenefit();
		
		// When
		SpecOfferBenefit actual = unit.convert(source);
		
		// Then
		assertEquals(expected, actual);
	}
}
