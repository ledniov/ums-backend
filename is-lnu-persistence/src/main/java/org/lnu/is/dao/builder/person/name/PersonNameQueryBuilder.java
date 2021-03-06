package org.lnu.is.dao.builder.person.name;

import org.lnu.is.dao.annotations.QBuilder;
import org.lnu.is.dao.builder.AbstractQueryBuilder;
import org.lnu.is.dao.builder.BaseQueryBuilder;
import org.lnu.is.domain.person.name.PersonName;

/**
 * Person name Query builder.
 * @author ivanursul
 *
 */
@QBuilder("personNameQueryBuilder")
public class PersonNameQueryBuilder extends AbstractQueryBuilder<PersonName> {
	private static final String PERSON_CONDITION = "e.person = :person ";
	private static final String LANGUAGE_CONDITION = ".language = :language ";
	private static final String NAME_CONDITION = "e.name LIKE CONCAT('%',:name,'%') ";
	private static final String FIRSTNAME_CONDITION = "e.firstName LIKE CONCAT('%',:name,'%') ";
	private static final String LASTNAME_CONDITION = "e.fatherName LIKE CONCAT('%',:fatherName,'%') ";
	private static final String SURNAME_CONDITION = "e.surname LIKE CONCAT('%',:surname,'%') ";

	@Override
	protected String getBaseQuery() {
		return "SELECT e FROM PersonName e %s";
	}

	@Override
	protected BaseQueryBuilder build(final PersonName context, final BaseQueryBuilder builder) {
		return builder
				.where()
				.openBracket()
					.addAndCondition(PERSON_CONDITION, context.getPerson())
					.addAndCondition(LANGUAGE_CONDITION, context.getLanguage())
					.addAndCondition(NAME_CONDITION, context.getName())
					.addAndCondition(FIRSTNAME_CONDITION, context.getFirstName())
					.addAndCondition(LASTNAME_CONDITION, context.getFatherName())
					.addAndCondition(SURNAME_CONDITION, context.getSurname())
				.closeBracket();
	}

}
