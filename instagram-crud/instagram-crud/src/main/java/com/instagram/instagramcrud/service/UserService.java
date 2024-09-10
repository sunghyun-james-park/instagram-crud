package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User theUser);

    void deleteById(Long id);
}
