package com.instagram.instagramcrud.dao;

import com.instagram.instagramcrud.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(Long id);

    User save(User theUser);

    void deleteById(Long id);

    //Test

}
