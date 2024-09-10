package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.entity.Follower;

import java.util.List;

public interface FollowerService {

    List<Follower> findAll();

    Follower findById(Long id);

    Follower save(Follower theFollower);

    void deleteById(Long id);
}
