package com.hibernatesimpleapp.dao;

import com.hibernatesimpleapp.entity.Post;
import com.hibernatesimpleapp.entity.PostDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Gustavo Pfeifer on 15/06/2017.
 */
@Transactional
public class PostDetailsDao implements IPostDetailsDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    public void savePost(String author, Post post) {
        PostDetails postDetail = new PostDetails();
        postDetail.setCreatedBy(author);
        postDetail.setPost(post);
        postDetail.setCreatedOn(new Date());
        hibernateTemplate.save(post);
    }


}
