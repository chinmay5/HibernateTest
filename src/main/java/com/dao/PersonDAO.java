/**
 * 
 */
package com.dao;

import java.util.List;

import com.hibernate.Person;

/**
 * @author OM
 *
 */

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
