package com.hibernatesimpleapp.dao;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.hibernatesimpleapp.entity.Person;
import org.hibernate.Query;

import java.util.*;

import com.hibernatesimpleapp.entity.Person;

@Transactional
public class PersonDao implements IPersonDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	public void savePerson() {
		Person person = new Person();
		person.setId(8);
		person.setName("Ram");
		hibernateTemplate.save(person);
	}

	 public List<Person> getAllPerson(){
		List<Person> list = hibernateTemplate.getSessionFactory()
						.getCurrentSession()
						.createCriteria(Person.class).list(); 
		return list;	 
	 }
} 