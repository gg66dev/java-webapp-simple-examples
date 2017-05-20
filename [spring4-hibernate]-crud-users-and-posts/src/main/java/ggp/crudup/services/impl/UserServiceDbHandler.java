package ggp.crudup.services.impl;

import ggp.crudup.entity.User;
import ggp.crudup.services.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Gustavo Pfeifer on 17/05/2017.
 */
@Transactional
public class UserServiceDbHandler implements UserService {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public void saveUser(User user) {
        System.out.println("en saveUser");
        hibernateTemplate.getSessionFactory()
                .getCurrentSession().save(user);
    }

    @Override
    public List<User> getUsers() {
        return hibernateTemplate.getSessionFactory()
                .getCurrentSession()
                .createCriteria(User.class).list();
    }

    @Override
    public User getUserByName(String value) {
        return getUser("name",value);
    }

    @Override
    public User getUserByEmail(String value) {
        return getUser("email",value);
    }

    private User getUser(String propertyName, String value){
        Session session = hibernateTemplate.getSessionFactory()
                .getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like(propertyName, value));
        List<User> userList = criteria.list();
        return (userList.size() > 0) ? userList.get(0) : null ;
    }
}
