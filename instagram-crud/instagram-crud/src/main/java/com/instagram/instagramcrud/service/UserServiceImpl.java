package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.dao.UserDAO;
import com.instagram.instagramcrud.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PostService postService;

    public UserServiceImpl(UserDAO userDAO, PostService postService) {
        this.userDAO = userDAO;
        this.postService = postService;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User user = userDAO.findById(id);
        if (user != null) {
            postService.deleteByUserId(id);
            userDAO.deleteById(id);
        }
    }
}
