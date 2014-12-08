package org.lnu.is.extractor.specoffer.benefit;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.benefit.Benefit;
import org.lnu.is.domain.specoffer.SpecOffer;
import org.lnu.is.domain.specoffer.SpecofferBenefit;
import org.lnu.is.extractor.AbstractParametersExtractor;
import org.springframework.stereotype.Component;

/**
 * Spec Offer Benefit Parameters Extractor.
 * @author ivanursul
 *
 */
@Component("specOfferBenefitParametersExtractor")
public class SpecOfferBenefitParametersExtractor extends AbstractParametersExtractor<SpecofferBenefit> {

	@Resource(name = "specOfferDao")
	private Dao<SpecOffer, Long> specOfferDao;
	
	@Resource(name = "benefitDao")
	private Dao<Benefit, Long> benefitDao;
	
	@Override
	public Map<String, Object> getParameters(final SpecofferBenefit entity) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		addParameter(entity.getSpecOffer(), specOfferDao, "specOffer", parameters);
		addParameter(entity.getBenefit(), benefitDao, "benefit", parameters);
		
		return parameters;
	}

}