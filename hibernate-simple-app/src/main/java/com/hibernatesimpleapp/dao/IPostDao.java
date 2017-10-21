package com.hibernatesimpleapp.dao;

import com.hibernatesimpleapp.entity.Post;

import java.util.List;

/**
 * Created by Gustavo Pfeifer on 15/06/2017.
 */
public interface IPostDao {

    public void savePost(String title);
    public List<Post> getAllPost();
}
