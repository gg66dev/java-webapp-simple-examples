package com.hibernatesimpleapp.dao;

import java.util.*;
import com.hibernatesimpleapp.entity.Person;

public interface IPersonDao {
  public void savePerson();

  public List<Person> getAllPerson();
} 