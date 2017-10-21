package com.hibernatesimpleapp;

import com.hibernatesimpleapp.dao.*;
import com.hibernatesimpleapp.entity.Post;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.hibernatesimpleapp.config.AppConfig;
import com.hibernatesimpleapp.entity.Person;

import java.util.*;

public class Spring4Hibernate4Test {
  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
	  ctx.refresh();

	  //getAllPersonExample(ctx);
	  oneToOneRelationshipExample(ctx);
  }


  public static void oneToOneRelationshipExample(AnnotationConfigApplicationContext ctx){
  	IPostDao postDao = ctx.getBean(IPostDao.class);
	postDao.savePost("First Post");
	postDao.savePost("Second Post");

	/*List<Post> postList = postDao.getAllPost();

	if(postList.size() > 0){
		IPostDetailsDao postDetailsDao = ctx.getBean(IPostDetailsDao.class);
		postDetailsDao.savePost("author 1", postList.get(0));
		postDetailsDao.savePost("author 2", postList.get(1));
		System.out.println("Done");
	}else{
		System.out.println("lista vacia");
	}*/



  }

  public static void getAllPersonExample(AnnotationConfigApplicationContext ctx){
	  IPersonDao pdao = ctx.getBean(IPersonDao.class);
	  //pdao.savePerson();

	  List<Person> list = pdao.getAllPerson();
	  for(Person p : list){
		  System.out.println(p.getName());
	  }
	  System.out.println("Done");
  }


} 