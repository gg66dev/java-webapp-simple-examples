package com.ggp.jwtsecuritydemo.dao;

import com.ggp.jwtsecuritydemo.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

}