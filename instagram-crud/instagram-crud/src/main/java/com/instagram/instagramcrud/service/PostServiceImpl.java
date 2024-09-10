package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.dao.PostDAO;
import com.instagram.instagramcrud.entity.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostDAO postDAO;

    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Post save(Post thePost) {
        return postDAO.save(thePost);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        postDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUserId(Long id) {
        List<Post> posts = postDAO.findByUserId(id);
        for (Post post : posts) {
            postDAO.delete(post);
        }
    }
}
