package com.hibernatesimpleapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.hibernatesimpleapp.config.AppConfig;
import com.hibernatesimpleapp.dao.IPersonDao;
import com.hibernatesimpleapp.entity.Person;

import java.util.*;

public class Spring4Hibernate4Test {
  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
	  ctx.refresh();
	  IPersonDao pdao = ctx.getBean(IPersonDao.class);
	  //pdao.savePerson();
	  
		List<Person> list = pdao.getAllPerson();
		for(Person p : list){
			System.out.println(p.getName());
		}
		
		System.out.println("Done");
  }
} 