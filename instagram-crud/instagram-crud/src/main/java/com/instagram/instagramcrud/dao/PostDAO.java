package com.instagram.instagramcrud.dao;

import com.instagram.instagramcrud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDAO extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
