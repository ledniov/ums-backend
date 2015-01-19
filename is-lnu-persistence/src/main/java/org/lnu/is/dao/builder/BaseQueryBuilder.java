package org.lnu.is.dao.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base Query Builder.
 * @author ivanursul
 *
 */
public class BaseQueryBuilder {
	
	private static final String WHERE = "WHERE ";
	private static final String OPEN_BRACKET = "( ";
	private static final String CLOSE_BRACKET = ") ";
	private static final String OR = "OR ";
	private static final String AND = "AND ";
	private static final List<String> WHERE_SINGLETON = Collections.singletonList(WHERE);
	private static final List<String> WHERE_OPENBRAKCETSINGLETON = Collections.singletonList(WHERE + OPEN_BRACKET);
	
	private String query;
	private List<String> conditions;
	
	/**
	 * Base Constructor.
	 * @param query
	 * @param conditions
	 * @param parameters
	 */
	public BaseQueryBuilder(final String query, final List<String> conditions) {
		super();
		this.query = query;
		this.conditions = conditions;
	}

	/**
	 * Method for getting conditions.
	 * @return conditions.
	 */
	public List<String> getConditions() {
		return conditions;
	}

	
	/**
	 * Method for building Base Query Builder.
	 * @param query
	 * @return Base Query Builder instnace.
	 */
	public static BaseQueryBuilder getInstance(final String query) {
		return new BaseQueryBuilder(query, new ArrayList<String>());
	}
	
	/**
	 * Method for adding condition with parameter.
	 * @param condition
	 * @param parameter
	 * @return Base query builder instance.
	 */
	public BaseQueryBuilder addOrCondition(final String condition, final Object parameter) {
		
		if (parameter != null) {
			or();
			getConditions().add(condition);
		}
		
		return this;
	}

	/**
	 * Method for adding and conditions.
	 * @param condition
	 * @param parameter
	 * @return this.
	 */
	public BaseQueryBuilder addAndCondition(final String condition, final Object parameter) {
		
		if (parameter != null) {
			and();
			getConditions().add(condition);
		}
		
		return this;
	}
	
	/**
	 * Checks if query builder contains conditions.
	 * @return boolean value
	 */
	private boolean hasConditions() {
		return WHERE_SINGLETON.equals(getConditions()) || WHERE_OPENBRAKCETSINGLETON.equals(getConditions());
	}

	/**
	 * Add open bracket.
	 * @return this
	 */
	public BaseQueryBuilder openBracket() {
		
		if (hasConditions()) {
			getConditions().set(0, WHERE + OPEN_BRACKET);
		} else {
			getConditions().add(OPEN_BRACKET);
		}
		
		return this;
	}

	/**
	 * Add closed bracket.
	 * @return this.
	 */
	public BaseQueryBuilder closeBracket() {
		
		if (hasConditions()) {
			getConditions().set(0, WHERE);
		} else {
			getConditions().add(CLOSE_BRACKET);
		}
		
		return this;
	}
	
	/**
	 * Where condition.
	 * @return Base Query builder.
	 */
	public BaseQueryBuilder where() {
		getConditions().add(WHERE);
		return this;
	}
	
	/**
	 * Or special word.
	 * @return Base Query Builder.
	 */
	public BaseQueryBuilder or() {
		
		if (!hasConditions()) {
			getConditions().add(OR);
		}
		
		return this;
	}

	/**
	 * Add and keyword.
	 * @return this
	 */
	public BaseQueryBuilder and() {
		
		if (!hasConditions()) {
			getConditions().add(AND);
		}
		
		return this;
	}
	
	/**
	 * Method for building final query.
	 * @return Final Query
	 */
	public String getFinalQuery() {
		return String.format(query, prepareConditions(conditions));
	}
	
	/**
	 * Method for preparing conditions.
	 * @param conditions
	 * @return Prepared conditions.
	 */
	private String prepareConditions(final List<String> conditions) {
		StringBuilder sb = new StringBuilder();
		
		if (!hasConditions()) {
			for (String condition: conditions) {
				sb.append(condition);
			}
		}
		
		return sb.toString();
	}

	/**
	 * Final method for builder - build query.
	 * @return ready query.
	 */
	public String build() {
		return getFinalQuery();
	}
}
