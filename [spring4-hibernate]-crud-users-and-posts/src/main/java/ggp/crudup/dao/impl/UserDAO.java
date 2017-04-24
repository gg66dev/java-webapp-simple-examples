package ggp.crudup.dao.impl;

import ggp.crudup.dao.IUserDAO;
import ggp.crudup.entity.User;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.hibernate.Query;

import java.util.*;


import java.util.List;

@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    private HibernateTemplate  hibernateTemplate;


    @Override
    public List<User> getAllUser() {
        List<User> list = hibernateTemplate.getSessionFactory()
                .getCurrentSession()
                .createCriteria(User.class).list();
        /*ArrayList<User> list = new ArrayList<>();
        User u = new User();
        u.setName("hola");
        list.add(u);*/
        return list;
    }
}
