package org.lnu.is.dao.builder.reason;

import org.lnu.is.dao.annotations.QBuilder;
import org.lnu.is.dao.builder.BaseQueryBuilder;
import org.lnu.is.dao.builder.QueryBuilder;
import org.lnu.is.domain.reason.Reason;

/**
 * Reason query builder.
 * @author ivanursul
 *
 */
@QBuilder("reasonQueryBuilder")
public class ReasonQueryBuilder implements QueryBuilder<Reason> {

	private static final String QUERY = "SELECT r FROM Reason r %s";

	private static final String NAME_CONDITION = "r.name LIKE CONCAT('%',:name,'%') ";
	private static final String ABBR_NAME_CONDITION = "r.abbrName LIKE CONCAT('%',:abbrName,'%') ";
	
	@Override
	public String build(final Reason context) {
		
		String query = BaseQueryBuilder.getInstance(QUERY)
				.where()
				.addOrCondition(NAME_CONDITION, context.getName())
				.addOrCondition(ABBR_NAME_CONDITION, context.getAbbrName())
				.build();

		return query;
	}

}
