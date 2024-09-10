package com.instagram.instagramcrud.service;

import com.instagram.instagramcrud.dao.FollowerDAO;
import com.instagram.instagramcrud.entity.Follower;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowerServiceImpl implements FollowerService {

    private FollowerDAO followerDAO;

    public FollowerServiceImpl(FollowerDAO followerDAO) {
        this.followerDAO = followerDAO;
    }

    @Override
    public List<Follower> findAll() {
        return followerDAO.findAll();
    }

    @Override
    public Follower findById(Long id) {
        return followerDAO.findById(id);
    }

    @Override
    @Transactional
    public Follower save(Follower theFollower) {
        return followerDAO.save(theFollower);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        followerDAO.deleteById(id);
    }
}
