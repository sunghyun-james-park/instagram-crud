package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post thePost);

    void deleteById(Long id);

    void deleteByUserId(Long id);
}
