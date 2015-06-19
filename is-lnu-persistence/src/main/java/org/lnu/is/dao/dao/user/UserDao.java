package org.lnu.is.dao.dao.user;

import org.lnu.is.dao.dao.Dao;
import org.lnu.is.domain.user.User;

/**
 * User dao interface.
 * @author ivanursul
 *
 */
public interface UserDao extends Dao<User, User, Long> {

	/**
	 * Method for getting user by login.
	 * @param login login
	 * @return User.
	 */
	User getUserByLogin(String login);
	
}
