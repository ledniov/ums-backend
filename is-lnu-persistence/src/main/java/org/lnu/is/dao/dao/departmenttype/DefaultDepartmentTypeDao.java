package org.lnu.is.dao.dao.departmenttype;

import org.lnu.is.dao.AbstractDao;
import org.lnu.is.domain.departmenttype.DepartmentType;
import org.springframework.stereotype.Repository;

/**
 * Default Department Type Dao.
 * @author ivanursul
 *
 */
@Repository("departmentTypeDao")
public class DefaultDepartmentTypeDao extends AbstractDao<DepartmentType, Long> implements DepartmentTypeDao {

	@Override
	public Class<DepartmentType> getEntityClass() {
		return DepartmentType.class;
	}

}
