package org.lnu.is.dao.builder.specialty;

import org.lnu.is.dao.annotations.QBuilder;
import org.lnu.is.dao.builder.AbstractQueryBuilder;
import org.lnu.is.dao.builder.BaseQueryBuilder;
import org.lnu.is.domain.specialty.Specialty;

/**
 * Specialty query builder. 
 * @author ivanursul
 *
 */
@QBuilder("specialtyQueryBuilder")
public class SpecialtyQueryBuilder extends AbstractQueryBuilder<Specialty> {
	private static final String PARENT_CONDITION = "e.parent = :parent ";
	private static final String SPECIALTYTYPE_CONDITION = "e.specialtyType = :specialtyType ";
	private static final String BEGDATE_CONDITION = "e.begDate <= :begDate ";
	private static final String ENDDATE_CONDITION = "e.endDate >= :endDate ";
	private static final String ABBRNAME_CONDITION = "e.abbrName LIKE CONCAT('%',:abbrName,'%') ";
	private static final String NAME_CONDITION = "e.name LIKE CONCAT('%',:name,'%') ";
	private static final String CIPHER_CONDITION = "e.cipher LIKE CONCAT('%',:cipher,'%') ";

	@Override
	protected String getBaseQuery() {
		return "SELECT e FROM Specialty e %s";
	}

	@Override
	protected BaseQueryBuilder build(final Specialty context, final BaseQueryBuilder builder) {
		return builder
				.where()
				.openBracket()
					.addAndCondition(PARENT_CONDITION, context.getParent())
					.addAndCondition(SPECIALTYTYPE_CONDITION, context.getSpecialtyType())
					.addAndCondition(ABBRNAME_CONDITION, context.getAbbrName())
					.addAndCondition(NAME_CONDITION, context.getName())
					.addAndCondition(CIPHER_CONDITION, context.getCipher())
					.addAndCondition(BEGDATE_CONDITION, context.getBegDate())
					.addAndCondition(ENDDATE_CONDITION, context.getEndDate())
				.closeBracket();
	}

}
