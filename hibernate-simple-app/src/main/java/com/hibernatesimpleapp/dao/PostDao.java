package com.hibernatesimpleapp.dao;


import com.hibernatesimpleapp.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Gustavo Pfeifer on 15/06/2017.
 */
@Transactional
public class PostDao implements IPostDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    public void savePost(String title) {
        Post post = new Post();
        post.setTitle(title);
        hibernateTemplate.save(post);
    }

    public List<Post> getAllPost(){
        List<Post> list = hibernateTemplate.getSessionFactory()
                .getCurrentSession()
                .createCriteria(Post.class).list();
        return list;
    }

}

