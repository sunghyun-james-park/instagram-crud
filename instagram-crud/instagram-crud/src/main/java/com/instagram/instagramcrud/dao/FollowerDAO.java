package com.instagram.instagramcrud.dao;

import com.instagram.instagramcrud.entity.Follower;

import java.util.List;

public interface FollowerDAO {

    List<Follower> findAll();

    Follower findById(Long id);

    Follower save(Follower theFollower);

    void deleteById(Long id);
}
