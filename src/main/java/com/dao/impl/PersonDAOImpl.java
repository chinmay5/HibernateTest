/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dao.PersonDAO;
import com.hibernate.Person;

/**
 * @author OM
 *
 */
public class PersonDAOImpl implements PersonDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
	}

	public List<Person> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}
	
	public List<Person> getListWithHibernate(){
		HibernateTemplate hibernateTemplate = new HibernateTemplate(this.sessionFactory);
		return (List<Person>)hibernateTemplate.find("from Person");
	}
	
	public void saveWithHibernate(Person person){
		if(person == null)
			return;
		HibernateTemplate hibernateTemplate = new HibernateTemplate(this.sessionFactory);
		hibernateTemplate.save(person);
		
	}

	public Person findById(int id) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(this.sessionFactory);
		return (Person) hibernateTemplate.find("from Person where id = ?", new Object[]{id});
	}

}
