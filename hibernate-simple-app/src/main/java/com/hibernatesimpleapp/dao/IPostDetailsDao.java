package com.hibernatesimpleapp.dao;

import com.hibernatesimpleapp.entity.Post;

/**
 * Created by Gustavo Pfeifer on 15/06/2017.
 */
public interface IPostDetailsDao {

    public void savePost(String author, Post post);
}
